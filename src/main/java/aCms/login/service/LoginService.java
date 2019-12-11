/*
 * CreateDay : 18. 10. 17 오후 12:22
 * fileName : LoginService.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.login.service;

import aCms.admin.account.domain.Account;
import aCms.login.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginDao loginDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginService(LoginDao loginDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.loginDao = loginDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveDefaultUserInfo(Account account, String[] roles){
        account.setEmail(account.getEmail());
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        /*Set<DefaultUserRole> roleSet = new HashSet<DefaultUserRole>();
        for(String role:roles){
            roleSet.add(new DefaultUserRole(role));
        }*/
        //defaultUserInfo.setDefaultUserRoles(roleSet);
        loginDao.save(account);
    }

    public Account findByEmail(String email){
        return loginDao.findByEmail(email);
    }

}
