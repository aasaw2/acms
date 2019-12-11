package aCms.admin.system.menu.domain;

/**
 * Created by Eido on 2018-11-08
 */

import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.system.menu.dao.Dto.MenuDetailDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_menu_detail")
public class MenuDetail extends BaseEntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_detail_id")
    private long menuSubId;
    @Column(name = "menu_detail_link",length = 50)
    private String menuSubLink;
    @Column(name = "menu_detail_Name", length = 10)
    private String menuSubName;
    @Column(name = "menu_detail_Zone", length = 10)
    private String menuSubZone;
    @Column(name = "menu_detail_sort")
    private int menuSubSort;
    @Column(name = "menu_detail_group")
    private int menuSubGroup;
    @Column(name = "menu_detail_level")
    private int menuSubLevel;

    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(name = "fk_menu_detail"))
    private Menu menu;

    public MenuDetail(MenuDetailDto.Write write, Menu menu) {
        this.menuSubLink = write.getMenuSubLink();
        this.menuSubGroup = write.getMenuSubGroup();
        this.menuSubZone = write.getMenuSubZone();
        this.menuSubSort = write.getMenuSubSort();
        this.menuSubLevel = write.getMenuSubLevel();
        this.menuSubName = write.getMenuSubName();
        this.menu = menu;
        this.cmd = "update";
    }

    public void update(MenuDetailDto.Update update, Menu menu) {
        this.menuSubLink = update.getMenuSubLink();
        this.menuSubGroup = update.getMenuSubGroup();
        this.menuSubZone = update.getMenuSubZone();
        this.menuSubSort = update.getMenuSubSort();
        this.menuSubLevel = update.getMenuSubLevel();
        this.menuSubName = update.getMenuSubName();
        this.menu = menu;
        this.cmd = "update";
    }


//    public void update(MenuDetail menuDetail){
//        this.menuSubLink = menuDetail.menuSubLink;
//        this.menuSubGroup = menuDetail.menuSubGroup;
//        this.menuSubZone = menuDetail.menuSubZone;
//        this.menuSubSort = menuDetail.menuSubSort;
//        this.menuSubLevel = menuDetail.menuSubLevel;
//        this.menuSubName = menuDetail.menuSubName;
//        this.cmd = "update";
//    }
//    public void setMenu(Menu menu){
//        this.menu = menu;
//        if(!menu.getMenuDetails().contains(this)){
//            menu.getMenuDetails().add(this);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "MenuDetail{" +
//                "menuSubName='" + menuSubName + '\'' +
//                '}';
//    }
}
