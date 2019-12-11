package aCms.admin.restriction.service;

import aCms.admin.restrictionMenu.dao.RestrictionMenuDao;
import aCms.admin.restrictionMenu.domain.RestrictionMenu;
import aCms.admin.restrictionMenu.domain.dto.RestrictionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestrictionService {

    private RestrictionMenuDao restrictionMenuDao;

    @Autowired
    public RestrictionService(RestrictionMenuDao restrictionMenuDao) {
        this.restrictionMenuDao = restrictionMenuDao;
    }

    public void create(RestrictionDto.create restrictionDto) {
        RestrictionMenu restriction = new RestrictionMenu(restrictionDto);
        restrictionMenuDao.save(restriction);
    }

    public RestrictionMenu findById(long id) {
        System.out.println("dsafds");
        RestrictionMenu restrictionMenu = restrictionMenuDao.findOne(id);
        return restrictionMenu;
    }

    public void update(long id, RestrictionDto.create restrictionDto) {
        RestrictionMenu restrictionMenu = findById(id);
        restrictionMenu.update(restrictionDto);
        restrictionMenuDao.save(restrictionMenu);
    }

    public void delete(long id) {
        restrictionMenuDao.delete(id);
    }
}
