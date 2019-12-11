package aCms.admin.mapper_entity.service;

import aCms.admin.account.domain.Account;
import aCms.admin.division.domain.Division;
import aCms.admin.mapper_entity.dao.MdaaDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
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
public class MdaaServiceTest {
   @Autowired
   MdaaService mdaaService;

   @Autowired
   MdaaDao mdaaDao;


   @Test
    public void list(){
        System.out.println(mdaaDao.findByDivisionId(Long.valueOf("41")));
    }


}
