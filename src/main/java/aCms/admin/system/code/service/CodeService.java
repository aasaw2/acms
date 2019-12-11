package aCms.admin.system.code.service;

import aCms.admin.system.code.dao.CodeDao;
import aCms.admin.system.code.dao.CodeDetailDao;
import aCms.admin.system.code.domain.Code;
import aCms.admin.system.code.domain.CodeDetail;
import aCms.admin.system.code.domain.dto.CodeDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CodeService {

    private CodeDao codeDao;
    private CodeDetailDao codeDetailDao;
    private ModelMapper modelMapper;

    @Autowired
    public CodeService(CodeDao codeDao, CodeDetailDao codeDetailDao, ModelMapper modelMapper) {
        this.codeDao = codeDao;
        this.codeDetailDao = codeDetailDao;
        this.modelMapper = modelMapper;
    }

    public void create(Code code) {
        System.out.println("code id : " + code.getId());
        codeDao.save(code);
    }

    public void update(Code code, long id) {
        Code code1 = codeDao.findOne(id);
        code1.update(code);
        codeDao.save(code1);
    }

    public void delete(long id) {
        codeDao.delete(id);
    }

    public List<Code> findAll() {
        return codeDao.findAll();
    }

    public PageImpl<Code> pageable(Pageable pageable) {
        List<Code> codeList;
        Page<Code> codePage = codeDao.findAll(pageable);
        codeList = codePage.getContent().parallelStream()
                .map(code -> modelMapper.map(code, Code.class))
                .collect(Collectors.toList());
        PageImpl<Code> result = new PageImpl<>(codeList, pageable, codePage.getTotalElements());
        return result;
    }

    public Code updatePage(long id) {
        Code code = codeDao.findOne(id);
        //TODO setCmd 하지 않도록 만들어 보기
        code.setCmd("update");
        return code;
    }

    public Code findCode(long id) {
        Code code = codeDao.findOne(id);
        return code;
    }

    public CodeDetail findCodeDetail(long detailId) {
        CodeDetail codeDetail = codeDetailDao.findOne(detailId);
        codeDetail.updateCmd();
        System.out.println("codeDetail cmd : ~ " + codeDetail.getCmd());
        return codeDetail;
    }

    public void codeDetailCreate(CodeDetailDto.Create codeDetailDto, long id) {
        CodeDetail codeDetail = new CodeDetail();
        Code code = codeDao.findOne(id);
        codeDetail.create(codeDetailDto , code);
        codeDetailDao.save(codeDetail);
    }

    public void codeDetailupdate(CodeDetailDto.Create codeDetailDto, long detailID) {
        CodeDetail codeDetail = codeDetailDao.findOne(detailID);
        codeDetail.update(codeDetailDto);
        codeDetailDao.save(codeDetail);
    }


    public void codeDetailDelete(long id) {
        codeDetailDao.delete(id);
    }

    public List<CodeDetail> findCodeDetailByCode(long id) {
        List<CodeDetail> codeDetails = codeDetailDao.findByCodeId(id);
        for (int i = 0; i < codeDetails.size(); i++) {
            System.out.println("code detail test");
            System.out.println(codeDetails.get(i).getId());
        }
        return codeDetails;
    }
}
