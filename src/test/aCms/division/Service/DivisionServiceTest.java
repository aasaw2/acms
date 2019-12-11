package aCms.admin.division.Service;

import aCms.admin.division.Dao.DivisionDao;
import aCms.admin.division.domain.Division;
import aCms.admin.mapper_entity.dao.MdaaDao;
import aCms.admin.mapper_entity.domain.Mdaa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
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
public class DivisionServiceTest {

    @Autowired
    DivisionDao divisionDao;

    @Autowired
    DivisionService divisionService;

    @Autowired
    MdaaDao mdaaDao;

    Calendar cal = Calendar.getInstance();
    Date day = new Date(cal.getTimeInMillis()); // Date(long date)

   /*@After
    public void cleanAll() {
        divisionDao.deleteAll();
    }*/

 /*   @Before
    public void setup() {
          List<Division> divisionList = new ArrayList<>();
        Authority authority = new Authority();
          for(int i=0;i<10;i++){
        authority.setId(Long.valueOf(i));
            Division division = Division.builder()
                    .name("경영지원팀_"+i).code("AA_BB_"+i).regName("테스트등록자_"+i)
                    .build();

            division.addMda(Mdaa.builder().authority(authority).build());
            division.addMda(Mdaa.builder().authority(authority).build());
            divisionList.add(division);
    }

//        System.out.println(divisionList);
        divisionDao.save(divisionList);

}*/


/*@Test
public void save() {
    Calendar cal = Calendar.getInstance();
    Date day = new Date(cal.getTimeInMillis()); // Date(long date)
    Division division = new Division();
    List<Division> divisionList = new ArrayList<>();

    List<Mdaa> mdaaList = new ArrayList<>();
    Authority authority = new Authority();

    division.setDivisionCode("AAA");
    division.setDivisionName("BBB");
    division.setRegDate(day);
    String[] arrayAAuthorityId = {"2", "3"};

    System.out.println("랭스:::::::" + arrayAAuthorityId.length);

        division = divisionDao.save(division);

        for (int i = 0; i < arrayAAuthorityId.length; i++){
            Mdaa mdaa = new Mdaa();
            System.out.println(":::::::::::::::::::::::::"+arrayAAuthorityId.length);
            System.out.println(":::::::::::::::::::::::::"+arrayAAuthorityId[0]);
            System.out.println(":::::::::::::::::::::::::"+arrayAAuthorityId[1]);


            authority.setId(Long.valueOf(arrayAAuthorityId[i]));
            mdaa.setDivision(division);
            mdaa.setAuthority(authority);
            mdaaDao.save(mdaa);
        }

        System.out.println("0000000");

    }*/

   /* @Test
    public void update() {
        List<Division> divisionList = new ArrayList<>();

        Division division = divisionDao.findOne(Long.valueOf("73"));

        division.setDivisionName("업데이트 테스트");
        String[] arrayAAuthorityId = {"1", "2", "3"};

        List<Mdaa> mdaaList = new ArrayList<>();
        mdaaList = mdaaDao.findByDivisionId(division.getId());
       // System.out.println("mdaaList::::::::"+mdaaList);


        division = divisionDao.save(division); // 수정된거 있음 업데이트 하고
        int dd = 0;
        for (int i = 0; i < arrayAAuthorityId.length; i++) {
            Mdaa mdaa = new Mdaa();
            Authority authority = new Authority();

            for (int ii = 0; ii < mdaaList.size(); ii++) {
 //               System.out.println("mdaaList.get(dd).getAuthority().getId():::"+mdaaList.get(dd).getAuthority().getId());
  //              System.out.println("Long.valueOf(arrayAAuthorityId[i])::::"+Long.valueOf(arrayAAuthorityId[i]));
                if(mdaaList.get(dd).getAuthority().getId() == Long.valueOf(arrayAAuthorityId[i])){
                    System.out.println("같은거");
                    mdaa.setId(mdaaList.get(ii).getId());
                    mdaa.setDivision(division);
                    authority.setId(mdaaList.get(dd).getAuthority().getId());
                    mdaa.setAuthority(authority);
                    mdaaDao.save(mdaa);
                    System.out.println("같은거:::::::::::"+mdaa);

                }*//*else{
                    System.out.println("다른거");
                    mdaa.setDivision(division);
                    authority.setId(Long.valueOf(arrayAAuthorityId[i]));
                    mdaa.setAuthority(authority);
                    mdaaDao.save(mdaa);
                    System.out.println("다른거:::::::::::"+mdaa);
                }*//*

            }


            mdaaDao.save(mdaa);
            if(i >= mdaaList.size()){
                dd++;
            }
        }
      //  System.out.println(division);
    }*/

    @Test
    public void Division여러개를_조회시_Mdaa가_N1_쿼리가발생한다() throws Exception {
        System.out.println("테스트테스트");

    //    System.out.println(divisionDao.findById(Long.valueOf("41")));
//        System.out.println(divisionDao.findAll());
        System.out.println(divisionDao.findOne(Long.valueOf("73")));
        //given
     //   List<String> mdaaName = divisionService.findAllMdaaName();
        //List<Division> divisions = divisionDao.findAllEntityGraphWithAuthority();
        //Division division = new Division();
        //System.out.println(divisionDao.findOneByDivisionId(Long.valueOf("41")));
        //System.out.println(divisionDao.findByO(Long.valueOf("62")));
        //System.out.println(divisionDao.findOne(Long.valueOf("61")));
        //System.out.println(divisionDao.findAllWithAuthority());
        //System.out.println(divisionDao.findAllEntityGraphWithAuthority());
       //then
       // assertThat(mdaaName.size(), is(20));
//        assertThat(divisions.size(), is(10));
    }


}