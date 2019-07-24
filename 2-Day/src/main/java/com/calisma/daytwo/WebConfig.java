package com.calisma.daytwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@ComponentScan(value = "com.calisma.daytwo")
public class WebConfig {

	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dt() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost/global");
		source.setUsername("root");
		source.setPassword("");
		return source;
	}
	
	
	
}
