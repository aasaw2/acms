package aCms.admin.system.menu.domain;

/**
 * Created by Eido on 2018-11-08
 */

import java.util.Set;
import javax.persistence.*;

import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "TB_menu")
@ToString
public class Menu extends BaseEntityDate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long menuId;
    @Column(name = "menu_group")
    private int menuGroup;
    @Column(name = "menu_level")
    private int menulevel;
    @Column(name = "menu_sort")
    private int menuSort;
    @Column(name = "menu_name",length = 10)
    private String menuName;
    @Column(name = "menu_link",length = 50)
    private String menuLink;
    @Column(name = "menu_zone", length = 10)
    private String menuZone;

    @OrderBy("menu_detail_sort asc")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu",cascade={CascadeType.ALL})
    //private List<MenuDetail> menuDetailsList = new ArrayList<MenuDetail>();
    private Set<MenuDetail> menuDetails;

    public void addMenuDetail (MenuDetail menuDetail){
        this.menuDetails.add(menuDetail);
        if(menuDetail.getMenu() != this ){
            menuDetail.setMenu(this);
        }
    }

    public void update(Menu menu) {
        this.menuDetails = menu.menuDetails;
        this.menuName = menu.menuName;
        this.menuLink = menu.menuLink;
        this.menuGroup = menu.menuGroup;
        this.menuSort = menu.menuSort;
        this.cmd = "update";
    }
}
