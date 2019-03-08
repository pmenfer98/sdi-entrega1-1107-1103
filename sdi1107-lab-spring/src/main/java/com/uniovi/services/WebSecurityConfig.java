package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
	return new SpringSecurityDialect();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests() // peticiones autorizadas
		.antMatchers(getPublicUrls()).permitAll()
		// Permite a todos los usuarios
		.anyRequest().authenticated()
		// pagina de autentificacion por defecto
		.and().formLogin().loginPage("/login").permitAll()
		// Si se loguea bien
		.defaultSuccessUrl("/home")
		// desconectarse
		.and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
	    throws Exception {
	auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder());
    }

    private String[] getPublicUrls() {
	List<String> publicUrls = new ArrayList<>();
	publicUrls.add("/css/**");
	publicUrls.add("/img/**");
	publicUrls.add("/script/**");
	publicUrls.add("/");
	publicUrls.add("/signup");
	publicUrls.add("/login");
	return (String[]) publicUrls.toArray(new String[publicUrls.size()]);
    }
}
