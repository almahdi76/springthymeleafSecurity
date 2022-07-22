package com.AKA.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConf  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder=passwordEncoder();
		String encodPWD=passwordEncoder.encode("1234");
		System.out.println(encodPWD);
		auth.inMemoryAuthentication()
//		.withUser("AAA").password("{noop}123").roles("USER")
//		.and()
//		.withUser("WWW").password("{noop}7898").roles("USER","ADMIN")
//		.and()
//		.withUser("BBB").password("{noop}1234").roles("USER");
		.withUser("almahdi").password(passwordEncoder.encode("123")).roles("USER")
		.and()
		.withUser("abusef").password(passwordEncoder.encode("789")).roles("USER","ADMIN")
		.and()
		.withUser("abdo").password(encodPWD).roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin().loginPage("/loging");
		http.formLogin();
		http.authorizeRequests().anyRequest().authenticated();
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


}
