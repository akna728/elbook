package com.example.demo.Config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Entity.AppConfig;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public AppConfig appConfig() {
		
		File imageDir = new File("src/main/resources/static/images/calligraphy");
		imageDir = imageDir.getAbsoluteFile();
		
		//imagesフォルダがなかったら作成する
		if(!imageDir.exists()) {
			imageDir.mkdir();
		}
		
		AppConfig appConfig = new AppConfig();
		appConfig.setImageDir(imageDir);
		System.out.println(imageDir);
		return appConfig;
		
	}

}
