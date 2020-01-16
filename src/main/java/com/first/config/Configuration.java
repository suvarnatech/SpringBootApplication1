package com.first.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.first")
@EnableCaching
//implements WebMvcConfigurer(If it doesnt workW properly then add this and jus implement all methods and keep)
public class Configuration{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public CacheManager cache() {
		return new ConcurrentMapCacheManager("employee");
	}

}
