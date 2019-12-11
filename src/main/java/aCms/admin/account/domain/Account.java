package aCms.admin.account.domain;


import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.authority.domain.Authority;
import aCms.admin.common.extend.BaseEntityDate;
import aCms.admin.division.domain.Division;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_account")
//@ToString(exclude = "division")
public class Account extends BaseEntityDate {
/*
*
* 1234 : $2a$10$VIoiake.AmVx28JxDbJdaeiRc9fNMQb2IOFbO.VStTLCXH5o4g7ta
*
* */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_email", length = 50)
    private String email;

    @Column(name = "account_password", length = 100)
    private String password;

    @Column(name = "account_name", length = 10)
    private String accountName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id", foreignKey = @ForeignKey(name = "FK_AUTHOIRTY_ID"))
    private Authority authority;

    @Builder
    public Account(Division division, String email, String name, String passowrd, Authority authority) {
        this.division = division;
        this.email = email;
        this.accountName = name;
        this.password = passowrd;
        this.authority = authority;
    }

    public void update(AccountDto.AccountUpdate accountUpdate) {
        this.password = accountUpdate.getPassword();
        this.accountName = accountUpdate.getAccountName();
        this.division = accountUpdate.getDivision();
        this.authority = accountUpdate.getAuthority();
    }

     /* / /==생성 메소드==/ /*/
//    public static Account createOrder(AccountDto.AccountWrite accountWrite, Division division) {
//        Account account = new Account();
//        account.setEmail(accountWrite.getEmail());
//        account.setAccountName(accountWrite.getAccountName());
//        account.setPassword(accountWrite.getPassword());
//        account.setDivision(division);
//        return account;
//    }

//    public void AccountUpdate(AccountDto.AccountUpdate accountUpdate, Account account, Division division) {
//        this.id = accountUpdate.getId();
//        this.email = accountUpdate.getEmail();
//        this.accountName = accountUpdate.getAccountName();
//        this.modDate = account.getRegDate();
//        this.division = division;
//    }
//    public void setDivision(Division division){
//        this.division = division;
//        if(!division.getAccount().contains(this)){
//            division.getAccount().add(this);
//        }
//    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                ", divisionId='" + division.getId() + '\'' +
                ", divisionCode='" + division.getDivisionCode() + '\'' +
                ", divisionName='" + division.getDivisionName() + '\'' +
//                ", mdaas='" + division.getMdaas() + '\'' +
                '}';
    }


}
