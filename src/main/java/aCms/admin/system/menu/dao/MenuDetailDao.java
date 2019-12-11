package aCms.admin.system.menu.dao;

import aCms.admin.system.menu.domain.MenuDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDetailDao extends JpaRepository<MenuDetail, Long> {
    List<MenuDetail> findByMenuMenuId(long id);
}
