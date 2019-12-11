package aCms.admin.authority.controller;

import aCms.admin.authority.dao.AuthorityDao;
import aCms.admin.authority.domain.Authority;
import aCms.admin.authority.domain.dto.AuthorityDto;
import aCms.admin.authority.service.AuthorityService;
import aCms.admin.common.Util;
import aCms.admin.system.menu.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequestMapping("/admin/Authority")
@Controller
public class AuthorityController extends Util {
    private AuthorityDao authorityDao;
    private AuthorityService authorityService;
    private ModelMapper modelMapper;
    private MenuService menuService;
//    private MappingTableService mappingTableService;

    @Autowired
    public AuthorityController(MenuService menuService ,AuthorityDao authorityDao, AuthorityService authorityService, ModelMapper modelMapper) {
        this.authorityDao = authorityDao;
        this.authorityService = authorityService;
        this.modelMapper = modelMapper;
        this.menuService = menuService;
//        this.mappingTableService = mappingTableService;
    }

    @RequestMapping(value = "/custom/list", method = GET)
    public String customList(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        System.out.println("/custom/authority working");
        Page<Authority> authorityPage = authorityDao.findAll(pageable);
        List<AuthorityDto.AuthorityList> authorityList;
        authorityList = authorityPage.getContent().parallelStream()
                .map(authority -> modelMapper.map(authority, AuthorityDto.AuthorityList.class))
                .collect(Collectors.toList());

        PageImpl<AuthorityDto.AuthorityList> result = new PageImpl<>(authorityList, pageable, authorityPage.getTotalElements());
        model.addAttribute("resultList", result);
        return "customAuthority";
    }

    @RequestMapping(value = "/detail/write", method = GET)
    public String detailList(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
//        Page<MenuAuthority> menuAuthorities = authorityService.findMenuAllList(pageable);
//        Page<ActionAuthority> actionAuthorities = authorityService.findActionAllList(pageable);
//        Page<DisplayAuthority> displayAuthorities = authorityService.findDisplayAllList(pageable);
//        model.addAttribute("resultList", menuAuthorities);
//        model.addAttribute("actionList", actionAuthorities);
//        model.addAttribute("displayList", displayAuthorities);
        return "detailAuthority";
    }

    @RequestMapping(value = "/list", method = GET)
    public String bannerWriteForm(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Authority> authorityPage = authorityDao.findAll(pageable);
        List<AuthorityDto.AuthorityList> authorityList;
        authorityList = authorityPage.getContent().parallelStream()
                .map(authority -> modelMapper.map(authority, AuthorityDto.AuthorityList.class))
                .collect(Collectors.toList());

        PageImpl<AuthorityDto.AuthorityList> result = new PageImpl<>(authorityList, pageable, authorityPage.getTotalElements());
        model.addAttribute("resultList", result);

        return  "authority_list";
    }

    @RequestMapping(value = "/write", method = GET)
    public String authorityWriteForm(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("resultList", menuService.findMenuDetailAll());
        return "authority_write";
    }

    @ResponseBody
    @RequestMapping(value = "/write", method = POST)
    public ResponseEntity authorityWrite(
            @RequestBody AuthorityDto.AuthorityWrite authorityWrite, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authority authority = authorityService.save(authorityWrite);
      return new ResponseEntity<>(HttpStatus.CREATED);

        //return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    public String authorityUpdateForm(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable Long id, Model model) {

        model.addAttribute("authority", authorityService.findAuthority(id));
        model.addAttribute("resultList", menuService.findMenuDetailAll());

        return "authority_write";
    }

    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = PUT)
    public ResponseEntity authorityUpdate(@PathVariable Long id,
            @RequestBody AuthorityDto.AuthorityWrite authorityWrite, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        authorityWrite.setId(id);
        Authority authority = authorityService.save(authorityWrite);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = DELETE)
    private ResponseEntity DeleteAuthority(@PathVariable Long id){
        authorityDao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

//    //권한 관리 페이지
//    @RequestMapping(value = "/authorityManager.ap", method = GET)
//    public String authorityManager(HttpSession session, Model model) {
//        System.out.println("권한 관리 페이지 클릭!!");
//
//        return "authorityManager";
//    }


}
