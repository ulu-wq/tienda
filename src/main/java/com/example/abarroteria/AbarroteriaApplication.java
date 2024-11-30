package com.example.abarroteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AbarroteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbarroteriaApplication.class, args);
	}
        
        
        @Bean
        public WebMvcConfigurer corsConfigurer2() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://losidiomasnuevo.web.app", "http://localhost:4200")
                        .allowCredentials(true)
                        .allowedHeaders("Origin", "Authorization", "Content-Type")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }           
        
        

}
