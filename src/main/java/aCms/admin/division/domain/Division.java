/*
 * CreateDay : 18. 10. 17 오후 7:13
 * fileName : Division.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.division.domain;


import aCms.admin.account.domain.Account;
import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.division.domain.dto.DivisionDto;
import aCms.admin.mapper_entity.domain.Mdaa;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TB_division")
@NoArgsConstructor
public class Division extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division_name")
    private String divisionName;

    @Column(name = "division_code")
    private String divisionCode;

    //    @OneToMany
//    @JoinColumn(name="division_id", insertable=false, updatable=false)
//    private List<Mdaa> mdaas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", insertable = false, updatable = false)
    private List<Mdaa> mdaas = new ArrayList<>();

    public void addMda(Mdaa mdaa) {
        this.mdaas.add(mdaa);
    }

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    private List<Account> account;

    public Division(DivisionDto.divisionView divisionDto) {
        this.id = divisionDto.getId();
        this.divisionCode = divisionDto.getDivisionCode();
        this.divisionName = divisionDto.getDivisionName();
        this.cmd = "update";
    }

    public Division(AccountDto.AccountWrite accountWrite) {
        this.id = Long.valueOf(accountWrite.getDivisionId());
    }

    public Division(DivisionDto.divisionWrite divisionDto) {
        this.divisionCode = divisionDto.getDivisionCode();
        this.divisionName = divisionDto.getDivisionName();
        this.cmd = "update";
    }


    public void DivisionInsert(DivisionDto.divisionWrite divisionWrite) {
        Calendar cal = Calendar.getInstance();
        Date day = new Date(cal.getTimeInMillis()); // Date(long date)
        Mdaa mdaa = new Mdaa();
//        mdaa.setAuthority(divisionWrite.getAuthority());
        this.divisionName = divisionWrite.getDivisionName();
        this.divisionCode = divisionWrite.getDivisionCode();
        this.regDate = day;
        this.mdaas.add(mdaa);
    }


    public void addAccount(Account account) {
        this.account.add(account);
        if (account.getDivision() != this) {
            account.setDivision(this);
        }
    }

    /* 테스트 데이터 용 */
    @Builder
    public Division(String code, String name, String regName) {
        Calendar cal = Calendar.getInstance();
        Date day = new Date(cal.getTimeInMillis()); // Date(long date)
        this.divisionCode = code;
        this.divisionName = name;
        this.regDate = day;
        this.regName = regName;
    }


    public void addMdaa(DivisionDto.divisionWrite divisionDto, Long id) {
        parseAuthorityData(divisionDto);
    }

    public List<String> parseAuthorityData(DivisionDto.divisionWrite divisionDto) {
        List<String> list = new ArrayList<>();
        String[] authorityArr = divisionDto.getAuthority().split(",");
        for (int i = 0; i < authorityArr.length; i++) {
            list.add(authorityArr[i]);
            System.out.println("what the");
            System.out.println(list.get(i));
        }
        return list;
    }

    public void addMdaas(List<Mdaa> mdaas) {
        for (int i = 0; i < mdaas.size(); i++) {
            this.mdaas.add(mdaas.get(i));
        }
    }

    public void update(DivisionDto.divisionWrite divisionDto) {
        this.divisionName = divisionDto.getDivisionName();
        this.divisionCode = divisionDto.getDivisionCode();
    }
}
