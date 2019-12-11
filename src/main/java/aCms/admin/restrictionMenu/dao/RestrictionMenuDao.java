package aCms.admin.restrictionMenu.dao;

import aCms.admin.restrictionMenu.domain.RestrictionMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionMenuDao extends JpaRepository<RestrictionMenu, Long> {
//    List<RestrictionMenu> findByMenusMenuId(Long id);
}
