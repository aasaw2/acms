/*
 * CreateDay : 18. 10. 17 오후 12:24
 * fileName : LoginDao.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.login.dao;

import aCms.admin.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}
