package aCms.admin.config.security;

import aCms.login.service.LoginDetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   /* private LoginDetalService loginDetalService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
*/

   /* @Autowired
    public WebSecurityConfig(LoginDetalService loginDetalService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.loginDetalService = loginDetalService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/

    @Autowired
    private LoginDetalService loginDetalService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
            .authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/WEB-INF/**").permitAll()
            .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")
            .and()
            .formLogin()
                .loginPage("/Login")
                .successHandler(new CustomAuthenticationSucces())
                .failureHandler(new CustomAuthenticationFailure())
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout_success")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(loginDetalService).passwordEncoder(bCryptPasswordEncoder());
    }

}
