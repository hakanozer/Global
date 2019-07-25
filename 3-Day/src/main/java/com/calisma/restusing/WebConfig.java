package com.calisma.restusing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@ComponentScan(value = "com.calisma.daytwo")
@PropertySource("classpath:application.properties")
public class WebConfig {

	@Value("${db.className}") String className;
	@Value("${db.url}") String url;
	@Value("${db.userName}") String userName;
	@Value("${db.pass}") String pass;
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dt() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(className);
		source.setUrl(url);
		source.setUsername(userName);
		source.setPassword(pass);
		return source;
	}
	
	@Bean(name = "restCache")
	public CacheManager cache() {
		return new ConcurrentMapCacheManager("allUserCache");
	}
	
	
	
}
