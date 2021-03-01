package com.jsprest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration

public class SuperAdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired

    AdminDetailsServiceImpl adminDetailsService;


    @Autowired

    private BCryptPasswordEncoder encoder;


//	
//	@Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }


    @Bean()
    @Override


    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override

    protected void configure(HttpSecurity http) throws Exception {


        http.cors().and().csrf().disable();
        http.antMatcher("/admin/**")
                .authorizeRequests().
                antMatchers("/admin/login", "/css/**", "/vendor/**", "/js/**", "/login")
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN").
                anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/loginPage")
                .defaultSuccessUrl("/admin/homePage")
                .failureUrl("/admin/loginPage?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/admin/loginPage?logout=true")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/admin/denied");


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .userDetailsService(adminDetailsService)

                .passwordEncoder(encoder);

    }


    /*
     *
     * @Bean public SecurityContextHolderAwareRequestFilter awareRequestFilter() {
     * return new SecurityContextHolderAwareRequestFilter(); }
     *
     * @Bean public SecurityContextPersistenceFilter persistenceFilter() { return
     * new SecurityContextPersistenceFilter(); }
     */

}