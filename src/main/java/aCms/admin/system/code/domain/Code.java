/*
 * CreateDay : 18. 11. 6 오후 4:04
 * fileName : Code.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.system.code.domain;

import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_code")
public class Code extends BaseEntityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Long id;

    @Column(name = "code_category")
    private String category;

    @Column(name = "code_group_id")
    private String codeGroupId;

    @Column(name = "code_group_name", length = 30)
    private String codeGroupName;

    @Column(name = "code_use")
    private int codeUse;

    @Column(name = "code_order")
    private String codeOrder;

    @OneToMany(mappedBy = "code")
    private List<CodeDetail> codeDetail;

    public void create(CodeDetail codeDetail) {
        this.codeDetail.add(codeDetail);
    }

    public void update(Code code) {
        this.codeDetail = code.codeDetail;
        this.codeGroupName = code.codeGroupName;
        this.codeGroupId = code.codeGroupId;
        this.codeOrder = code.codeOrder;
        this.codeUse = code.codeUse;
        this.cmd = "update";
    }

    public void updateCmd() {
        this.cmd = "update";
    }




    /*
    *
    * @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="division_id", insertable=false, updatable=false)
    private List<Mdaa> mdaas = new ArrayList<>();

    public void addMda(Mdaa mdaa){
        this.mdaas.add(mdaa);
    }

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    private List<Account> account;
    * */



}
