package aCms.admin.page.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TB_mapping_account_authority")
public class MappingAccountAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reg_date")
    private Date reg_date;

    @Column(name = "reg_username")
    private String reg_username;

    @Column(name = "modify_date")
    private Date modify_date;

    @Column(name = "modify_username")
    private String modify_username;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "authroity_id")
    private int authroity_id;

//    @ManyToOne
//    @JoinColumn(name = "FK_user_id", foreignKey = @ForeignKey(name = "FK_ACCOUNT_ID"))
//    private Account account;
//
//    @ManyToOne
//    @JoinColumn(name = "FK_authroity_id", foreignKey = @ForeignKey(name = "FK_AUTHORITY_ID"))
//    private Authority authority;
}
