package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.Entity.AppConfig;

@Configuration
public class WebConfig {
	
	@Autowired
	private AppConfig appConfig;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String imageDirUri = appConfig.getImageDir().toURI().toString();
		registry.addResourceHandler("/images/calligraphy/**").addResourceLocations(imageDirUri);
		
	}
	

}
