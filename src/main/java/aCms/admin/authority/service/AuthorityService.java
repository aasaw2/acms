package aCms.admin.authority.service;

import aCms.admin.authority.dao.AuthorityDao;
import aCms.admin.authority.domain.Authority;
import aCms.admin.authority.domain.dto.AuthorityDto;
import aCms.admin.restrictionMenu.dao.RestrictionMenuDao;
import aCms.admin.restrictionMenu.domain.RestrictionMenu;
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
public class AuthorityService {

    private RestrictionMenuDao restrictionMenuDao;
    private AuthorityDao authorityDao;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorityService(AuthorityDao authorityDao, ModelMapper modelMapper, RestrictionMenuDao restrictionMenuDao) {
        this.authorityDao = authorityDao;
        this.modelMapper = modelMapper;
        this.restrictionMenuDao = restrictionMenuDao;
    }

    public Authority save(AuthorityDto.AuthorityWrite authorityWrite) {
        Authority authority = new Authority();
        authority.setId(authorityWrite.getId());
        authority.Authority(authorityWrite);
        return authorityDao.save(authority);

    }

    public PageImpl<AuthorityDto.AuthorityList> authorityList(Pageable pageable) {
        Page<Authority> authorityPage = authorityDao.findAll(pageable);
        List<AuthorityDto.AuthorityList> authorityList;

        authorityList = authorityPage.getContent().parallelStream()
                .map(authority -> modelMapper.map(authority, AuthorityDto.AuthorityList.class))
                .collect(Collectors.toList());

        PageImpl<AuthorityDto.AuthorityList> result = new PageImpl<>(authorityList, pageable, authorityPage.getTotalElements());
        return result;
    }

    public Page<RestrictionMenu> restrictsPageList(Pageable pageable) {
        Page<RestrictionMenu> restrictionMenus = restrictionMenuDao.findAll(pageable);
        return restrictionMenus;
    }

    public Authority findAuthority(Long id) {
        Authority authority = authorityDao.findOne(id);
        authority.setCmd("update");
        return authority;
//        authorityDao.findAuthorityWithRestriction(id);
    }

}
