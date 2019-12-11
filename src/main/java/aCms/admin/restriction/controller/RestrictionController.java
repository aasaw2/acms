package aCms.admin.restriction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/restriction")
public class RestrictionController {

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        System.out.println("restriction write page");
        return "restrictionWrite";
    }
}
