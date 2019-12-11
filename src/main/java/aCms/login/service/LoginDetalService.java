/*
 * CreateDay : 18. 10. 17 오후 12:23
 * fileName : LoginDetalService.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.login.service;

import aCms.admin.account.domain.Account;
import aCms.admin.authority.dao.AuthorityDao;
import aCms.login.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginDetalService implements UserDetailsService {
    private LoginDao loginDao;
    private AuthorityDao authorityDao;

    @Autowired
    public LoginDetalService(LoginDao loginDao, AuthorityDao authorityDao) {
        this.loginDao = loginDao;
        this.authorityDao = authorityDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = loginDao.findByEmail(username);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        /*
            for(DefaultUserRole role : LoginService.getDefaultUserRoles()){
                grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
            }
        */

        if (account.getAuthority().getRegName().equals("user")) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority("USER"));
        } else {
            grantedAuthoritySet.add(new SimpleGrantedAuthority("ADMIN"));
            grantedAuthoritySet.add(new SimpleGrantedAuthority("USER"));
        }
        return new User(account.getEmail(),account.getPassword(),grantedAuthoritySet);
    }

}
