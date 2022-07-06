package com.unbox.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;



@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		List<String> corsHeaders = new ArrayList<>();
 		corsHeaders.add("Authorization");
 		corsHeaders.add("Cache-Control");
 		corsHeaders.add("Content-Type");
		corsHeaders.add("Access-Control-Allow-Origin");
		corsHeaders.add("Accept");
		corsHeaders.add("Origin");
		corsHeaders.add("X-Requested-With");
		corsHeaders.add("Access-Control-Request-Headers");
		corsHeaders.add("Access-Control-Request-Method");

 		List<String> originsHeaders = new ArrayList<>();
 		originsHeaders.add("http://13.232.97.200");
 		originsHeaders.add("http://localhost:3000");

 		List<String> methodsHeaders = new ArrayList<>();
 		methodsHeaders.add("GET");
 		methodsHeaders.add("POST");
 		methodsHeaders.add("PATCH");
 		methodsHeaders.add("PUT");
 		methodsHeaders.add("DELETE");
 		methodsHeaders.add("OPTIONS");

 		List<String> exposedHeaders = new ArrayList<>();
 		exposedHeaders.add("Authorization");

        CorsConfiguration  corsConfiguration=new CorsConfiguration();
		
        corsConfiguration.setAllowedHeaders(corsHeaders);
 		corsConfiguration.setAllowedOrigins(originsHeaders);
		
 		corsConfiguration.setAllowedMethods(methodsHeaders);

		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setExposedHeaders(exposedHeaders);
		
		http.csrf().and().cors().disable().formLogin();		
		http.authorizeRequests().antMatchers("/signUp","/signIn","/sendMail").permitAll()
		
		.anyRequest().authenticated().and().csrf().disable().cors().configurationSource(request->corsConfiguration);
	}
	@Bean
	public RestTemplate getResttemplate() {
		return new RestTemplate();
	}
}