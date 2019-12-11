/*
 * CreateDay : 18. 10. 17 오전 11:58
 * fileName : CustomAuthenticationFailure.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomAuthenticationFailure implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        request.setAttribute("username", request.getParameter("username"));
        request.getRequestDispatcher("/loginError.ap").forward(request, response);
    }
}
