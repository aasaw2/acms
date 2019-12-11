/*
 * CreateDay : 18. 10. 17 오후 3:59
 * fileName : AccountControllerTest.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.account.controller;

import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.division.domain.Division;
import aCms.admin.egovframework.example.sample.service.EgovSampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

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
public class AccountControllerTest {

    @Autowired
    AccountService accountService;

    @Autowired
    EgovSampleService egovSampleService;

    @Autowired
    AccountDao accountDao;

    @Test
    public void joinMember() {
        AccountDto.AccountWrite accountWrite = new AccountDto.AccountWrite();

        accountWrite.setEmail("admin");
        accountWrite.setPassword("test");
        accountWrite.setAccountName("관리자");
        accountWrite.setAuthorityId("1,2");

        System.out.println(accountWrite.toString());


        Account account = accountService.join(accountWrite);

        System.out.println("인서트 완료");

    }

  @Test
    public  void list(){
      System.out.println(accountDao.findOne(Long.valueOf(13)));
  }
}
