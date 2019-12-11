package aCms.login.controller;


import aCms.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/Login")
    public String loginPage(){
        return "loginPage";
    }

    @RequestMapping(value = "/logout_success")
    public String loginOut(){
        return "loginPage";
    }
}
