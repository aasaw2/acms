package aCms.admin.system.menu.service;
/**
 * Created by Eido on 2018-11-08
 */


import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.system.menu.dao.Dto.MenuDetailDto;
import aCms.admin.system.menu.dao.MenuDao;
import aCms.admin.system.menu.dao.MenuDetailDao;
import aCms.admin.system.menu.domain.Menu;
import aCms.admin.system.menu.domain.MenuDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuService {

   private MenuDao menuDao;
   private ModelMapper modelMapper;
   private MenuDetailDao menuDetailDao;
   private AccountDao accountDao;

   @Autowired
   public MenuService(ModelMapper modelMapper, MenuDao menuDao, MenuDetailDao menuDetailDao) {
       this.modelMapper = modelMapper;
       this.menuDao = menuDao;
       this.menuDetailDao = menuDetailDao;
   }


    @Cacheable("menuList")
    public List<Menu> selectMenu(){
        System.out.println("start menu service");
//        Account user = findAccount();
//        parseAuthority(user);
        List<Menu> selectMenuList = menuDao.findAllMenu();
        return selectMenuList;
    }

    private void parseAuthority(Account user) {
       user.getAuthority().parseAuthority();
    }

    private Account findAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =(User) authentication.getPrincipal();
        System.out.println("user : " + user.getUsername());
        Account account = accountDao.findByEmail(user.getUsername());
        System.out.println("account email : " + account.getEmail());
        return account;
    }

    //    @Transactional(rollbackFor = Exception.class)
    public void create(Menu menu) {
//        try {
//            Exception e = new Exception("예외 발생");
//            throw e;
//        } catch (Exception e) {
//            System.out.println("에러!"+e.getMessage());
//            e.printStackTrace();
//        }
       menuDao.save(menu);
    }


    public void update(Menu menu, long menuId) {
//        System.out.println("읽기전용");
        Menu menu1 = menuDao.findOne(menuId);
        menu1.update(menu);
        menuDao.save(menu1);
    }

    public void delete(long menuId) {
       menuDao.delete(menuId);
    }

    public List<Menu> findAll() { return menuDao.findAll();}

    public PageImpl<Menu> pageable(Pageable pageable) {
        List<Menu> menuList;
        Page<Menu> menuPage = menuDao.findAll(pageable);
        menuList = menuPage.getContent().parallelStream()
                .map(menu -> modelMapper.map(menu, Menu.class))
                .collect(Collectors.toList());
        PageImpl<Menu> result = new PageImpl<>(menuList, pageable, menuPage.getTotalElements());
        return result;
    }

    public Long countMenu(){
        Long countMenuSum = menuDao.count();
        return countMenuSum;
    }

    public Menu updatePage(long menuId) {
       Menu menu = menuDao.findOne(menuId);
       return menu;
    }


    /************
     * Detail 정의
     ************/

    public PageImpl<MenuDetail> detail_pageable(Pageable pageable) {
        List<MenuDetail> menuDetailList;
        Page<MenuDetail> menuDetailPage = menuDetailDao.findAll(pageable);
        menuDetailList = menuDetailPage.getContent().parallelStream()
                .map(menuDetail -> modelMapper.map(menuDetail, MenuDetail.class))
                .collect(Collectors.toList());
        PageImpl<MenuDetail> result = new PageImpl<>(menuDetailList, pageable, menuDetailPage.getTotalElements());
        System.out.println("메뉴리스트:::::");
        return result;
    }


    public void detail_delete(long menuSubId) {
        System.out.println("삭제 서비스 시작:::::"+menuSubId);
        menuDetailDao.delete(menuSubId);
        System.out.println("삭제 서비스 종료");
    }


    public MenuDetail detailUpdatePage(long menuSubId) {
        MenuDetail menuDetail = menuDetailDao.findOne(menuSubId);
        menuDetail.setCmd("update");
        return menuDetail;
    }


    public MenuDetail detail_write(MenuDetailDto.Write write) {
        Menu menu = menuDao.findOne(write.getMenuId());
        MenuDetail menuDetail = new MenuDetail(write, menu);
        return menuDetailDao.save(menuDetail);
    }

    public MenuDetail detail_update(long menuSubId, MenuDetailDto.Update update) {
        Menu menu = menuDao.findOne(update.getMenuId());
        MenuDetail menuUpdate = menuDetailDao.findOne(menuSubId);
        menuUpdate.update(update, menu);
        return menuDetailDao.save(menuUpdate);
    }


    public List<MenuDetail> findAll(long id) {
        System.out.println(id);
        List<MenuDetail> menuDetaillist = menuDetailDao.findByMenuMenuId(id);
        System.out.println(menuDetaillist.size());
        return menuDetaillist;
    }

    public Menu menuIdUpdate(long menuSubId) {
        return menuDao.findByMenuDetailsMenuSubId(menuSubId);
    }

    public List<Menu> findMenuAll() {
        return menuDao.findAll();
    }

    public List<MenuDetail> findMenuDetailAll() {
        return menuDetailDao.findAll();
    }
}
