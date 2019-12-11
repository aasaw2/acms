package aCms.admin.authority.domain;


import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.authority.domain.dto.AuthorityDto;
import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TB_authority")
public class Authority extends BaseEntityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long id;

    @Column(name = "authority_code")
    private String authorityCode;

    @Column(name = "authority_name" , length = 30)
    private String name;

    @Column(name = "authority_Url")
    private String authorityUrl;

    @Column(name = "authority_create")
    private String create;

    @Column(name = "authority_read")
    private String read;

    @Column(name = "authority_update")
    private String update;

    @Column(name = "authority_delete")
    private String delete;

    public Authority(AccountDto.AccountWrite accountWrite) {
        this.id = Long.valueOf(accountWrite.getAuthorityId());
    }


    public void Authority(AuthorityDto.AuthorityWrite authorityWrite) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Calendar cal = Calendar.getInstance();
        Date day = new Date(cal.getTimeInMillis()); // Date(long date)
        this.authorityCode = authorityWrite.getAuthorityCode();
        this.name = authorityWrite.getName();
        this.authorityUrl = authorityWrite.getAuthorityUrl();
        this.regDate = day;
        this.regName = user.getUsername();
        this.create = authorityWrite.getCreate();
        this.read = authorityWrite.getRead();
        this.update = authorityWrite.getUpdate();
        this.delete = authorityWrite.getDelete();
        System.out.println(regName);
    }

    public void parseAuthority() {
        System.out.println("parseAuthority() check");
        System.out.println("create : " + getCreate());
        System.out.println("read : " + getRead());
        System.out.println("update : " + getUpdate());
        System.out.println("delete : " + getDelete());
    }
}
