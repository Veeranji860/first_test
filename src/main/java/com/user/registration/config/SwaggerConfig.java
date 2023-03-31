package com.user.registration.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	private String get() {
		String a="secreate4 is2 a3 This1";
		String[] aa= a.split(" ");
		ArrayList<String> sort=new ArrayList<>();
		for(int i=0;i<aa.length;i++) {
			sort.add(aa[i].lastIndexOf(i), aa[i]);
		}
				
		
		return null;
	}

}
