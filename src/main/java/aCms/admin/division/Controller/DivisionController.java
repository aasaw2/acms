/*
 * CreateDay : 18. 10. 17 오후 7:13
 * fileName : Division.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.division.Controller;

import aCms.admin.authority.domain.dto.AuthorityDto;
import aCms.admin.authority.service.AuthorityService;
import aCms.admin.common.Util;
import aCms.admin.division.Service.DivisionService;
import aCms.admin.division.domain.dto.DivisionDto;
import aCms.admin.mapper_entity.service.MdaaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RequestMapping("/admin/Division")
@Controller
public class DivisionController extends Util {

    private ModelMapper modelMapper;
    private DivisionService divisionService;
    private AuthorityService authorityService;
    private MdaaService mdaaService;

    @Autowired
    public DivisionController(ModelMapper modelMapper, AuthorityService authorityService, DivisionService divisionService, MdaaService mdaaService) {
        this.modelMapper = modelMapper;
        this.divisionService = divisionService;
        this.authorityService = authorityService;
        this.mdaaService = mdaaService;
    }

    //부서 리스트 조회 및 페이징
    @RequestMapping(value = "/list", method = GET)
    public String ListDivision(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        PageImpl<DivisionDto.divisionList> divisions = divisionService.divisionList(pageable);
        model.addAttribute("resultList", divisions);
        return "division_list";
    }

    //부서 추가 페이지 이동
    @RequestMapping(value = "/write", method = GET)
    public String WriteDivisionForm(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        PageImpl<AuthorityDto.AuthorityList> authorityLists = authorityService.authorityList(pageable);
        model.addAttribute("resultList", authorityLists);
        return "division_write";
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    public String UpdateDivisionForm(@PathVariable Long id, @PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
//        Division division = divisionService.findDivision(id);
//        PageImpl<AuthorityDto.AuthorityList> authorityLists = authorityService.authorityList(pageable);
//        List<Mdaa> mdaaList = mdaaService.findByDivisionID(id);
        model.addAttribute("resultList", authorityService.authorityList(pageable));
        model.addAttribute("division", divisionService.findDivision(id));
        model.addAttribute("mdaaList", mdaaService.findByDivisionID(id));
        return "division_write";
    }

//    @RequestMapping(value = "/update/{id}", method = GET)
//    public String UpdateDivisionForm(@PathVariable Long id, @PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
//        Division division = divisionService.findDivision(id);
//
//
//        division.setCmd("update");
//
//
//        List<Mdaa> mdaa = mdaaDao.findByDivisionId(id);
//        List<Authority> authorityList = new ArrayList<>();
//        authorityList = authorityDao.findAll();
//        List<Account> accounts = new ArrayList<>();
//        accounts = accountDao.findAll();
//        Page<Account> accountPage = accountDao.findAll(pageable);
//        List<AccountDto.AccountList> accountList;
//        accountList = accountPage.getContent().parallelStream()
//                .map(account -> modelMapper.map(account, AccountDto.AccountList.class))
//                .collect(Collectors.toList());
//
//        PageImpl<AccountDto.AccountList> result = new PageImpl<>(accountList, pageable, accountPage.getTotalElements());
//        model.addAttribute("resultList", result);
//
////        model.addAttribute("divisionAccount", divisionAccount);
//        model.addAttribute("mdaa", mdaa);
//        model.addAttribute("division", division);
//        model.addAttribute("authorityList", authorityList);
//        model.addAttribute("accountList", accounts);
//        return "division_write";
//    }

//    // TODO : 업데이트 시 mdss의 삭제가 나중에 일어남 먼저 일어나게 수정 해야지
//    @ResponseBody
//    @RequestMapping(value = "/update/{id}", method = POST)
//    public ResponseEntity eUpdateDivision(@PathVariable Long id,
//                                          @Valid DivisionDto.divisionWrite divisionWrite, BindingResult result) {
//        if (result.hasErrors()) {
//            System.out.println(result.getAllErrors());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        divisionWrite.setId(id);
////        Division division = divisionService.update(divisionWrite);
////        return new ResponseEntity<>(modelMapper.map(division, DivisionDto.divisionView.class), HttpStatus.CREATED);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @RequestMapping(value = "/delete/{id}", method = DELETE)
    @ResponseBody
    private HashMap DeleteDivision(@PathVariable Long id, String authorityId) {
        divisionService.delete(id);
        return getResultMap("success", "삭제되었습니다.");
    }

}