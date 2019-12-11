/*
 * CreateDay : 18. 10. 22 오후 2:22
 * fileName : AccountServiceTest.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.account.service;

import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.division.domain.Division;
import aCms.admin.mapper_entity.domain.Mdaa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/egovframework/spring/context-datasource.xml",
        "classpath:/egovframework/spring/context-hibernate.xml",
        "classpath:/egovframework/spring/context-common.xml",
        "classpath:/egovframework/spring/context-security.xml",
        "classpath:/egovframework/spring/context-aspect.xml",
        "classpath:/egovframework/spring/context-properties.xml",
        "classpath:/egovframework/spring/context-transaction.xml",
        "classpath:/egovframework/spring/context-mapper.xml",
        "classpath:/egovframework/spring/context-sqlMap.xml",
        "classpath:/egovframework/spring/context-idgen.xml"
})

@Transactional
public class AccountServiceTest {


    @Autowired
    AccountDao accountDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//bCryptPasswordEncoder.encode(accountWrite.getPassword()));
   /* @Before
    public void setup() {
        Division division = new Division();
        Authority authority = new Authority();

        List<Account> accountList = new ArrayList<>();
        division.setId(Long.valueOf("31"));
        authority.setId(Long.valueOf("1"));

        for (int i = 0; i < 10; i++) {
            Account account = Account.builder()
              //      .email("test_id_" + i).name("테스트이름_"+i).passowrd("테스트패스워드").divisionId(Long.valueOf("62")).build();
               .email("test_id_" + i).name("테스트이름_"+i).passowrd(bCryptPasswordEncoder.encode("1234")).division(division).build();

         //   account.getDivision().addMda(Mdaa.builder().division(division).authority(authority).build());
            accountList.add(account);
        }

        System.out.println(":::::::::::::::::"+accountList);
        accountDao.save(accountList);
    }
*/

    @Test
    public void list() {
        System.out.println("완룝");
 //       System.out.println(accounts);

        Account account = accountDao.findByEmail("test_id_0");
        System.out.println("::::::::::::::::::::::::::::::"+account);
        System.out.println("::::::::::::::::::::::::::::::"+account.getDivision());
        System.out.println("::::::::::::::::::::::::::::::"+account.getDivision().getMdaas().size());
        System.out.println("::::::::::::::::::::::::::::::"+account.getDivision().getMdaas().get(0));
        System.out.println("::::::::::::::::::::::::::::::"+account.getDivision().getMdaas().get(1));
        System.out.println("::::::::::::::::::::::::::::::"+account.getDivision().getMdaas().get(2));

  //      System.out.println(accountDao.findAllJoinFetch());

        //String email = "test_id_0";
        //System.out.println(accountDao.findByEmail(email));
      //  Account account = accountDao.findByEmail(email);
       // Division division = new Division();


        //System.out.println("account.getDivision().getMdaas():::::::"+account);
    }
}

