package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nnk.springboot.services.UserService;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
     private UserService userDetailsService;
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 
	    http.authorizeRequests()
	            .antMatchers("/bidList/**", "/rating/**", "/ruleName/**", "/trade/**", "/curvePoint/**").hasAnyAuthority("ADMIN", "USER")
	            .antMatchers("/user/**").permitAll()
	            .and().formLogin()  
	            .defaultSuccessUrl("/bidList/list")
	            .and().logout()    
	            .logoutUrl("/app-logout")
	            .logoutSuccessUrl("/")
	            .and().exceptionHandling()
	            .accessDeniedPage("/app/error");
	    http.sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	            .maximumSessions(1);
	}
	
	 @Bean 
	 public PasswordEncoder bCryptPasswordEncoder() { 
		 return new BCryptPasswordEncoder(); }

	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

	 }
}
