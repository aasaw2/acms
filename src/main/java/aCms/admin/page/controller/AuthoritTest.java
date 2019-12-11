package aCms.admin.page.controller;

import aCms.admin.page.service.MappingAccountAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AuthoritTest {

    @Autowired
    private MappingAccountAuthorityService mappingAccountAuthorityService;

    @RequestMapping(value = "authoritytest")
    public String test(Principal principal) {
        System.out.println("dsaflakdfljabsdlgjbasdjgbaljebtojqwheitjndflmga,smd 1!!!!!!!!!!");
        String email = principal.getName();
//        MappingAccountAuthority test = mappingAccountAuthorityService.findMaa();
        mappingAccountAuthorityService.findMaa(email);
//        System.out.println("authority test!!!! : " + test.getAuthority());
        return "authorityTest";
    }
}
