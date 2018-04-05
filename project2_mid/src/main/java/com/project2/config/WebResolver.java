package com.project2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.project2")
public class WebResolver extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver()
	{
		System.out.println("Resolver Called");
		InternalResourceViewResolver iRVResolver=new InternalResourceViewResolver();
		iRVResolver.setViewClass(JstlView.class);
		iRVResolver.setPrefix("/WEB-INF");
		iRVResolver.setSuffix(".jsp");
		return iRVResolver;
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer con)
	{
		con.enable();
	}
}
