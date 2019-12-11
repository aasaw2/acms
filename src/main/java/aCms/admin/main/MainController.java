package aCms.admin.main;


import aCms.admin.system.menu.domain.Menu;
import aCms.admin.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
   /* private MenuService menuService;

    public MainController(MenuService menuService) {
        this.menuService = menuService;
    }*/
   @Autowired
   MenuService menuService;

    @RequestMapping("/admin/main")
    public String main(HttpSession session, Model model){
     //   System.out.println("메인 시작!!");
        List<Menu> menuSelectList = menuService.selectMenu();
     //   System.out.println(":::::::::::::::::::::"+menuSelectList);
        System.out.println("menu start!!");
        for (int i = 0; i < menuSelectList.size(); i++) {
            System.out.println(menuSelectList.get(i).getMenuId());
            System.out.println(menuSelectList.get(i).getMenuName());
        }
        model.addAttribute("leftMenu",menuSelectList);
        session.setAttribute("leftMenu",menuSelectList);
        return "adminMainPage";
    }

}
