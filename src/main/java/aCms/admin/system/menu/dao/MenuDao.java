package aCms.admin.system.menu.dao;


import aCms.admin.system.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao extends JpaRepository<Menu, Long>{

    Menu findByMenuDetailsMenuSubId(long menuSubId);

    @Query("select distinct a from Menu a left join fetch a.menuDetails")
    List<Menu> findAllMenu();
}