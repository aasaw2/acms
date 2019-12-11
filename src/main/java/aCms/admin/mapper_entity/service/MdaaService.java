package aCms.admin.mapper_entity.service;

import aCms.admin.authority.dao.AuthorityDao;
import aCms.admin.authority.domain.Authority;
import aCms.admin.division.domain.Division;
import aCms.admin.division.domain.dto.DivisionDto;
import aCms.admin.mapper_entity.dao.MdaaDao;
import aCms.admin.mapper_entity.domain.Mdaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MdaaService {

/* private MdaaDao mdaaDao;

    public MdaaService(MdaaDao mdaaDao) {
        this.mdaaDao = mdaaDao;
    }*/

    @Autowired
    MdaaDao mdaaDao;

    @Autowired
    private AuthorityDao authorityDao;

    public void save(Mdaa mdaa) {
        mdaaDao.save(mdaa);
    }

    public List<Mdaa> mdaas(Mdaa mdaa) {
        List<Mdaa> mdaas = mdaaDao.findAll();
        //mdaa = mdaaDao.findOne(mdaa.getId());
        return mdaas;
    }

    public List<Mdaa> findByDivisionID(long id) {
        List<Mdaa> list = mdaaDao.findByDivisionId(id);
        return list;
    }

    public List<Mdaa> create(DivisionDto.divisionWrite divisionDto, Division division) {
        List<Mdaa> mdaas = new ArrayList<>();
        List<String> authorityNames = division.parseAuthorityData(divisionDto);
        for (int i = 0; i < authorityNames.size(); i++) {
            Authority authority = authorityDao.findByName(authorityNames.get(i));
            Mdaa mdaa = new Mdaa(division, authority);
            Mdaa mdaaSave = mdaaDao.save(mdaa);
            mdaas.add(mdaaSave);
        }
        return mdaas;
    }

//    public List<Mdaa> update() {
//        List<Mdaa> mdaas = new ArrayList<>();
//        for (int i = 0; i < authorityNames.size(); i++) {
//            Authority authority = authorityDao.findByName(authorityNames.get(i));
//            Mdaa mdaa = new Mdaa(division, authority);
//            Mdaa mdaaSave = mdaaDao.save(mdaa);
//            mdaas.add(mdaaSave);
//        }
//        return mdaas;
//    }

    public void deleteAll(long id) {
        mdaaDao.deleteDivisionId(id);
    }
}
