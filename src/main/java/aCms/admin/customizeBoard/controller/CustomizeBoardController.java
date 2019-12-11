package aCms.admin.customizeBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomizeBoardController {

    @RequestMapping("/customizeBoard")
    public String customPage() {
        System.out.println("customize board page working");
        return "customizeBoard";
    }
}
