/*

 * CreateDay : 18. 11. 8 오후 1:58
 * fileName : MenuController.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.system.menu.controller;

import aCms.admin.system.menu.dao.Dto.MenuDetailDto;
import aCms.admin.system.menu.domain.Menu;
import aCms.admin.system.menu.domain.MenuDetail;
import aCms.admin.system.menu.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {


//    @PersistenceContext
//    private EntityManager em;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    private ModelMapper modelMapper;
//    private MenuDao menuDao;
    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService, ModelMapper modelMapper) {
        this.menuService = menuService;
        this.modelMapper = modelMapper;
    }

//    @RequestMapping("/list.ap")
//    public String menuList(Model model){
//        JPAQuery query = new JPAQuery(em);
//        System.out.println("메뉴 리스트:::");
//        QMenu qMenu = QMenu.menu;
//        List<Menu> menuList = (List<Menu>) query.from(qMenu).list(qMenu);
//        System.out.println(":::::::::::::"+menuList);
//        model.addAttribute("menuList",menuList);
//        System.out.println("메뉴 끝");
//        return "menuList";
//    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String menuList(@PageableDefault(size = 10, sort = "menuId", direction = Sort.Direction.DESC) Pageable pageable , Model model) {
        System.out.println("메뉴 스타트");
        PageImpl<Menu> menus = menuService.pageable(pageable);
        System.out.println("메뉴 중간");
        for (int i = 0; i < menus.getSize(); i++) {
            menus.getTotalElements();
            menus.getTotalPages();
        }
        model.addAttribute("menuList", menus);
        System.out.println("메뉴 끝");
        return "menuList";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        System.out.println("등록 시작");
        return "menuWrite";
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Menu menu) {
        System.out.println("메뉴 생성 시작 클릭 입력 받은 값 :" +menu.getMenuName());
        menuService.create(menu);
        System.out.println("생성 Service 통과");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{menuId}", method = RequestMethod.GET)
    public String updatePage(@PathVariable long menuId, Model model) {
        model.addAttribute("menu", menuService.updatePage(menuId));
        System.out.println("메뉴 업데이트 방문");
        return "menuWrite";
    }


    @ResponseBody
    @RequestMapping(value = "/update/{menuId}", method = RequestMethod.POST)
    public ResponseEntity update(@PathVariable long menuId, @RequestBody Menu menu) {
        menuService.update(menu, menuId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{menuId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long menuId) {
        System.out.println("삭제 컨트롤러 진입");
        menuService.delete(menuId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /************************
         MenuDetail 정의
     ************************/


    @RequestMapping(value = "/detailwrite", method = RequestMethod.GET)
    public String detail_Write(Model model) {
        List<Menu> menuDetailList = menuService.selectMenu();
        model.addAttribute("menuDetailList", menuDetailList);
        return "menuDetailWrite";
    }

    @RequestMapping(value = "/detailupdate/{menuSubId}", method = RequestMethod.GET)
    public String detail_updatePage(@PathVariable long menuSubId, Model model) {
        System.out.println("접근시작");
        List<Menu> menuDetailList = menuService.selectMenu();
        model.addAttribute("menuDetailList", menuDetailList);
        model.addAttribute("menuDetail", menuService.detailUpdatePage(menuSubId));
        System.out.println("메뉴 업데이트");
        return "menuDetailWrite";
    }


    @ResponseBody
    @RequestMapping(value = "/detailupdate/{id}", method = RequestMethod.POST)
    public ResponseEntity detail_update(@PathVariable long id, @RequestBody MenuDetailDto.Update menuDetailDto, BindingResult result) {
        System.out.println("메뉴 업데이트 시작!!!");
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MenuDetail menuDetail = menuService.detail_update(id, menuDetailDto);
        System.out.println("Update 종료::::::::::::"+id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/detailcreate", method = RequestMethod.POST)
    public ResponseEntity Menu_Write(
            @Valid @RequestBody MenuDetailDto.Write menuDetailDto, BindingResult result) {
        System.out.println("Create 스타트");

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MenuDetail menuDetail = menuService.detail_write(menuDetailDto);
        System.out.println("Create 종료::::::::::::"+menuDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @ResponseBody
    @RequestMapping(value = "/detaildelete/{menuSubId}", method = RequestMethod.DELETE)
    public ResponseEntity detail_delete(@PathVariable long menuSubId) {
        System.out.println("삭제 컨트롤러 진입");
        menuService.detail_delete(menuSubId);
        System.out.println("삭제 컨트롤러 완료");
        return new ResponseEntity(HttpStatus.OK);
    }

    //메뉴 디테일 리스트
    @RequestMapping(value = "/detaillist/{menuSubId}", method = RequestMethod.GET)
    public String menuDetailList(@PathVariable long menuSubId, Model model) {
        System.out.println("메뉴 디테일 스타트");
        List<MenuDetail> menuDetailList = menuService.findAll(menuSubId);
        model.addAttribute("menuDetailList", menuDetailList);
        return "menuDetailList";
    }

}
