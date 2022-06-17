package com.unbox.config;

import java.util.List;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.client.RestTemplate;

import org.springframework.web.cors.CorsConfiguration;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean

	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

		corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000","http://13.232.97.200"));

		corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS"));

		corsConfiguration.setAllowCredentials(true);

		corsConfiguration.setExposedHeaders(List.of("Authorization"));

		http.csrf().and().cors().disable().formLogin();

		http.authorizeRequests()
				.antMatchers("/signup","/signIn")
				.permitAll()

				// http.authorizeRequests().antMatchers("/addFileContent/{id}","/addContentDb","/addFileDb","/update-password/{id}","/getTopic/{type}","/verfiyEamil","/resetPass/{email}","/Admin-reset-password","/adminSignIn","/addInfo","/contactUs","/imageUploadLong/{Id}","/user/upload","/saveQuick","/getTopic/{type}","/saveContent","/getUser","/save","/sendotp","/verfiyotp","/creatorProfile/{id}","/image/{id}","/verifyEmail","/createPassword","/signIn","/Forgot-password","/verfiyotpEmail","/resetPassword/{userId}","/getEnabled/{id}","/user-profile/{id}","/getImage/{id}","/imageUploadCourse/{Id}","/imageUploadQUick/{Id}").permitAll()

				.anyRequest().authenticated().and().csrf().disable().cors()
				.configurationSource(request -> corsConfiguration);

	}

	@Bean

	public RestTemplate getResttemplate() {

		return new RestTemplate();

	}

}