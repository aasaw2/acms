package aCms.admin.system.code.controller;

import aCms.admin.system.code.domain.Code;
import aCms.admin.system.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin/code")
public class CodeController {

    private CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String codeList(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable , Model model) {
        PageImpl<Code> codes = codeService.pageable(pageable);
        model.addAttribute("codeList", codes);
        return "codeList";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "codeWrite";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable long id, Model model) {
        model.addAttribute("code", codeService.updatePage(id));
        model.addAttribute("codeDetailList", codeService.findCodeDetailByCode(id));
        return "codeWrite";
    }

    @RequestMapping(value = "/codeDetail/{id}", method = RequestMethod.GET)
    public String codeDetailPage(@PathVariable long id , Model model) {
        model.addAttribute("code", codeService.findCode(id));
        System.out.println("id is working? : " + id);
        return "codeDetailPage";
    }

    @RequestMapping(value = "/codeDetail/write", method = RequestMethod.GET)
    public String codeDetailWritePage() {
        return "codeDetailPage";
    }

    @RequestMapping(value = "/{id}/update/{detailId}", method = RequestMethod.GET)
    public String codeDetailUpdatePage(@PathVariable long id, @PathVariable long detailId, Model model) {
        System.out.println("update is worked?" + id + " : " + detailId);
        model.addAttribute("code", codeService.findCode(id));
        model.addAttribute("codeDetail" , codeService.findCodeDetail(detailId));
        return "codeDetailPage";
    }

}
