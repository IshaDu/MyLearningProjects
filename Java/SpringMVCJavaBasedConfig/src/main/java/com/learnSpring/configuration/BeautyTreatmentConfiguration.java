package com.learnSpring.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.learnSpring.dao.BeautyTreatmentDAO;
import com.learnSpring.dao.BeautyTreatmentDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.learnSpring")
public class BeautyTreatmentConfiguration implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver =new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/JSP/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	// Method for database connectivity
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/learn");
		dataSource.setUsername("root");
		dataSource.setPassword("Ishaisha1#");
		return dataSource;
		
	}
	  // This function creates a new instance of BeautyTreatmentDAOImpl providing the BeautyTreatmentDAOImpl // class with database connectivity
		
		  @Bean
		  public BeautyTreatmentDAO getBeautyTreatmentDAO() 
		  { 
			  return new BeautyTreatmentDAOImpl(getDataSource()); 
	      }
		 
	 
	
	
	
}
