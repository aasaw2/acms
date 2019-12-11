/*
 * CreateDay : 18. 10. 17 오전 11:58
 * fileName : CustomAuthenticationSucces.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


public class CustomAuthenticationSucces implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        SimpleGrantedAuthority sg = new SimpleGrantedAuthority("ADMIN");
        if (authorities.contains(sg)) {
            System.out.println("admin login page");
            redirectStrategy.sendRedirect(request, response, "/admin/main");
        } else {
            System.out.println("user login");
            redirectStrategy.sendRedirect(request, response, "/main");
        }
    }
}
