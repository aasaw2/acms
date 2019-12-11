package aCms.admin.page.service;

import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.authority.domain.Authority;
import aCms.admin.page.dao.MappingAccountAuthorityDAO;
import aCms.admin.page.domain.MappingAccountAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MappingAccountAuthorityService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MappingAccountAuthorityDAO mappingAccountAuthorityDAO;

    @Transactional
    public String findMaa(String email) {
        Account account = accountDao.findByEmail(email);
        System.out.println("principal please..~~~~ : " + account.getId());

        String strQuery = "select m from MappingAccountAuthority as m where m.user_id=:user_id";
//        String strQuery = "select m from MappingAccountAuthority as m ";
        Query query = entityManager.createQuery(strQuery);
        query.setParameter("user_id", 61);
//        query.setParameter("user_id", account.getId().intValue());

                                                                                                                                                                                               List<MappingAccountAuthority> result = query.getResultList();

        for(MappingAccountAuthority maa : result) {
            String strAuthorityQuery = "select a from Authority as a where a.id=:id";
            Query autorityQuery = entityManager.createQuery(strAuthorityQuery);
            autorityQuery.setParameter("id", maa.getId());

            Authority authority = (Authority)autorityQuery.getSingleResult();


        }

//        TypedQuery<MappingAccountAuthority> query = entityManager.createQuery(strQuery, MappingAccountAuthority.class);

        System.out.println("Asdf");

        List<MappingAccountAuthority> test = mappingAccountAuthorityDAO.findAll();
//        System.out.println("test account : " + test.get(0).getAccount());
//        System.out.println("test authority : " + test.get(0).getAuthority());
        return "AsdF";
    }

}
