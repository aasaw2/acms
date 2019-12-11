/*
 * CreateDay : 18. 10. 17 오후 7:16
 * fileName : DivisionService.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.division.Service;


import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.division.Dao.DivisionDao;
import aCms.admin.division.domain.Division;
import aCms.admin.division.domain.dto.DivisionDto;
import aCms.admin.mapper_entity.dao.MdaaDao;
import aCms.admin.mapper_entity.domain.Mdaa;
import aCms.admin.mapper_entity.service.MdaaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DivisionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DivisionService.class);

    Calendar cal = Calendar.getInstance();
    Date day = new Date(cal.getTimeInMillis()); // Date(long date)

    private DivisionDao divisionDao;
    private MdaaDao mdaaDao;
    private AccountDao accountDao;
    private ModelMapper modelMapper;
    private MdaaService mdaaService;

    @Autowired
    public DivisionService(MdaaService mdaaService, DivisionDao divisionDao, MdaaDao mdaaDao, AccountDao accountDao, ModelMapper modelMapper) {
        this.divisionDao = divisionDao;
        this.mdaaDao = mdaaDao;
        this.accountDao = accountDao;
        this.modelMapper = modelMapper;
        this.mdaaService = mdaaService;
    }

    public void delete(Long id) {
        Division DivisionOriginalData = divisionDao.findOne(id);
        System.out.println(DivisionOriginalData);
        int mdaaSize = DivisionOriginalData.getMdaas().size();

        for (int i=0; i<mdaaSize; i++){
            mdaaDao.deleteDivisionId(DivisionOriginalData.getMdaas().get(i).getId());
        }

        divisionDao.delete(DivisionOriginalData.getId());
    }

//    public Division save(DivisionDto.divisionWrite divisionWrite) {
//
//        List<Division> divisionList = new ArrayList<>();
//        Division division = new Division();
//        Authority authority = new Authority();
//
//            division.setDivisionCode(divisionWrite.getDivisionCode());
//            division.setDivisionName(divisionWrite.getDivisionName());
//            String[] arrayAAuthorityId = divisionWrite.getAuthorityId().split(","); //권한 아이디 배열
//
//         division = divisionDao.save(division);
//
//         if(!divisionWrite.getAuthorityId().equals("") || divisionWrite.getAuthorityId() != null) {
//             for (int i = 0; i < arrayAAuthorityId.length; i++) {
//                 Mdaa mdaa = new Mdaa();
//                 authority.setId(Long.valueOf(arrayAAuthorityId[i]));
//                 mdaa.setDivision(division);
//                 mdaa.setAuthority(authority);
//                 mdaaDao.save(mdaa);
//             }
//         }
//        return division;
//    }

//    public Division update(DivisionDto.divisionWrite divisionWrite) {
//
//        Division division = new Division();
//        Authority authority = new Authority();
//        Division DivisionOriginalData = divisionDao.findOne(divisionWrite.getId());
//
//        List<Mdaa> mdaas = mdaaDao.findByDivisionId(divisionWrite.getId());
//        System.out.println("::::"+mdaas.size());
//
//        if(mdaas.size() > 0){
//            for (int i = 0; i<mdaas.size(); i++) {
//                mdaaDao.deleteById(mdaas.get(i).getId());
//            }
//        }
//
//        division.setDivisionCode(divisionWrite.getDivisionCode());
//        division.setDivisionName(divisionWrite.getDivisionName());
//        division.setId(DivisionOriginalData.getId());
//        division.setRegDate(DivisionOriginalData.getRegDate());
//
//        division = divisionDao.save(division);
//
//        division.setId(DivisionOriginalData.getId());
////        String[] arrayAAuthorityId = divisionWrite.getAuthorityId().split(","); //권한 아이디 배열
//
//        Mdaa mdaa = new Mdaa();
//
//        for (int i = 0; i<arrayAAuthorityId.length; i++){
//            mdaa = new Mdaa();
//            authority.setId(Long.valueOf(arrayAAuthorityId[i]));
//            mdaa.setDivision(division);
//            mdaa.setAuthority(authority);
//            mdaaDao.save(mdaa);
//        }
//
//            division = new Division();
//        division.setId(divisionWrite.getId());
//
//        return division;
//    }

    @Transactional
    public List<Account> findDivisionAccount(long id) {
        List<Account> divisionAccounts = new ArrayList<>();
        divisionAccounts = accountDao.findByDivisionId(id);
        return divisionAccounts;
    }

    public Division findDivision(long id) {
        Division division = divisionDao.findById(id);
        division.setCmd("update");
        return division;
    }

    //부서 리스트 페이징으로 보내주기
    public PageImpl<DivisionDto.divisionList> divisionList(Pageable pageable) {
        Page<Division> divisionPage = divisionDao.findAll(pageable);
        List<DivisionDto.divisionList> divisionList;

        divisionList = divisionPage.getContent().parallelStream()
                .map(division -> modelMapper.map(division, DivisionDto.divisionList.class))
                .collect(Collectors.toList());

        PageImpl<DivisionDto.divisionList> result = new PageImpl<>(divisionList, pageable, divisionPage.getTotalElements());
        return result;
    }

    public void create(DivisionDto.divisionWrite divisionDto) {
        Division division = new Division(divisionDto);
        Division division1 = divisionDao.save(division);
        List<Mdaa> mdaas = mdaaService.create(divisionDto, division1);
        division1.addMdaas(mdaas);
        divisionDao.save(division1);
    }

    public void update(long id, DivisionDto.divisionWrite divisionDto) {
        mdaaService.deleteAll(id);
        Division division = divisionDao.findById(id);
        division.update(divisionDto);
        Division updateDivision = divisionDao.save(division);
        List<Mdaa> mdaas = mdaaService.create(divisionDto, updateDivision);
        updateDivision.addMdaas(mdaas);
        divisionDao.save(updateDivision);
    }



    private void parseAuthority(DivisionDto.divisionWrite divisionDto) {
    }

}
