package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main 
{
	/*
	 * 1. Jackson library is provided by spring boot to us
	 * 2. Tomcat server is also provided by spring boot
	 * 3. @SpringBootApplication
	 * 			a. @Configuration
	 * 			b. @ComponentScan
	 * 			c. @EnabledAutoConfiguration
	 * 
	 */
    public static void main( String[] args )
    {
        SpringApplication.run(Main.class, args);
        
        /*String bean[] = context.getBeanDefinitionNames();
        for(String s : bean) {
        	System.out.println(s);
        }*/
    }
}
