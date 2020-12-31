package com.manko.helpdeskfinal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class HelpDeskSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		System.out.println("");
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select korisnicko_ime,lozinka,status from helpdesksb.korisnik where korisnicko_ime = ?")
		.authoritiesByUsernameQuery("select korisnicko_ime,naziv_uloge from korisnik e\r\n"
				+ "inner join korisnici_uloge ur on e.id_korisnik = ur.id_korisnik\r\n"
				+ "inner join uloge r on r.id_uloge = ur.id_uloge where korisnicko_ime = ?");


		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers( "/").authenticated().and().formLogin().loginPage("/loginPage")
		.loginProcessingUrl("/processLogin").permitAll();

	}

	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		return passwordEncoder;
	
	
}
}
