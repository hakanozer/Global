package com.calisma.restusing;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter   {

	
	@Autowired DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery("select mail, role from user where mail = ?")
		.usersByUsernameQuery("select mail, pass, statu from user where mail = ?");
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.anyRequest().authenticated();
		
		http.csrf().disable();
	}
	
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
	
	
}
