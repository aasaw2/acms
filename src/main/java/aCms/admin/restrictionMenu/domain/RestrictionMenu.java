package aCms.admin.restrictionMenu.domain;

import aCms.admin.authority.domain.Authority;
import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.restrictionMenu.domain.dto.RestrictionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_restriction_menu")
public class RestrictionMenu extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restriction_menu_id")
    private long id;

    @Column(name = "restriction_menu_name")
    private String name;

    @Column(name = "restriction_menu_url")
    private String url;

    @Column(name = "restriction_menu_create")
    private String create;

    @Column(name = "restriction_menu_read")
    private String read;

    @Column(name = "restriction_menu_update")
    private String update;

    @Column(name = "restriction_menu_delete")
    private String delete;

//    @OneToMany(mappedBy = "restrictionMenu",fetch = FetchType.LAZY)
//    private List<Menu> menus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id", foreignKey = @ForeignKey(name = "FK_RESTRICTION_MENU_AUTHOIRTY_ID"))
    private Authority authority;

    public RestrictionMenu(RestrictionDto.create restrictionDto) {
        this.name = restrictionDto.getName();
        this.url = restrictionDto.getUrl();
        this.create = restrictionDto.getCreate();
        this.read = restrictionDto.getRead();
        this.update = restrictionDto.getUpdate();
        this.delete = restrictionDto.getDelete();
        this.cmd = "cmd";
    }

    public void update(RestrictionDto.create restrictionDto) {
        this.name = restrictionDto.getName();
        this.url = restrictionDto.getUrl();
        this.create = restrictionDto.getCreate();
        this.read = restrictionDto.getRead();
        this.update = restrictionDto.getUpdate();
        this.delete = restrictionDto.getDelete();
    }
}
