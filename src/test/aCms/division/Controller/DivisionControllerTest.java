package aCms.admin.division.Controller;

import aCms.admin.division.Dao.DivisionDao;
import aCms.admin.division.domain.Division;
import org.hibernate.Hibernate;
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
public class DivisionControllerTest {

    @Autowired
    DivisionDao divisionDao;

    @Test
    public void divisionList() {
        Division division = new Division();
        division = divisionDao.findOne(Long.valueOf(62));
        //System.out.println(divison.getMdaas().get(0).getAuthority());
       // divisionDao.findById(Long.valueOf(62));
       // Hibernate.initialize(division.getMdaas());

      //  System.out.println("------------------------------------------"+division.toString());
     /*   System.out.println("asdfasdf:::"+division.getMdaas().get(1).getAuthority());
        System.out.println("------------------------------------------");
        System.out.println("aaaaaa:::"+division.getMdaas());
        System.out.println("------------------------------------------");*/
     //   System.out.println(divisionDao.findAllWithAuthority());
    }
}