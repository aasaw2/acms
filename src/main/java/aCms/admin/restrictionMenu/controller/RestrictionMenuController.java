package aCms.admin.restrictionMenu.controller;

import aCms.admin.restriction.service.RestrictionService;
import aCms.admin.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestrictionMenuController {

    private MenuService menuService;
    private RestrictionService restrictionService;

    @Autowired
    public RestrictionMenuController(MenuService menuService, RestrictionService restrictionService) {
        this.menuService = menuService;
        this.restrictionService = restrictionService;
    }

    @RequestMapping(value = "/restrictionmenu/write", method = RequestMethod.GET)
    public String write(Model model) {
        model.addAttribute("menuList" ,menuService.findMenuAll());
        return "restrictionMenuWrite";
    }

    @RequestMapping(value = "/restriction/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id, Model model) {
        restrictionService.findById(id);
        model.addAttribute("restriction", restrictionService.findById(id));
        model.addAttribute("menuList", menuService.findMenuAll());
        return "restrictionMenuWrite";
    }
}
