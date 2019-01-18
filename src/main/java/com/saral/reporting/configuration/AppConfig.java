package com.saral.reporting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.saral.reporting")
public class AppConfig extends WebMvcConfigurerAdapter{

	/**
     * Configure TilesConfigurer.
     */
	@Bean
	public TilesConfigurer tilesConfigurer(){
	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
	    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
	    tilesConfigurer.setCheckRefresh(true);
	    return tilesConfigurer;
	}

	/**
     * Configure ViewResolvers to deliver preferred views.
     */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.tiles();
	}
	
	
	
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/assets/**").addResourceLocations("assets/");
	        System.out.println();
	        registry.addResourceHandler("/ckeditor/**").addResourceLocations("ckeditor/");
	        
	        registry.addResourceHandler("/js/**").addResourceLocations("js/");
	        
	        registry.addResourceHandler("/css/**").addResourceLocations("css/");
	    }	
}

