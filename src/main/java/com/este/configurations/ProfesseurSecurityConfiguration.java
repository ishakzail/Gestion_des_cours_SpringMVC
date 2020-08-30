package com.este.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;



import com.este.service.ProfesseurService;

@EnableWebSecurity
@Configuration
@Order(1)
public class ProfesseurSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private ProfesseurService professeurService;
	
	
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.cors().and().csrf().disable();
		
		httpSecurity.antMatcher("/professeur/**")
					.authorizeRequests()
					.antMatchers("/professeur/**").access("hasRole('ROLE_PROFESSEUR')")
					.and()
					.formLogin()
					.loginPage("/professeur-panel")
					.loginProcessingUrl("/professeur/process-login")
					.defaultSuccessUrl("/professeur-panel/welcome" , true)
					.failureUrl("/professeur-panel/login?error")
					.usernameParameter("email").passwordParameter("motdepass")
					.and()
					.logout()
					.logoutUrl("/professeur/process-logout")
					.logoutSuccessUrl("/professeur-panel/login?logout")
					.deleteCookies("JSESSIONID")
					.and()
					.exceptionHandling().accessDeniedPage("/professeur-panel/accesDenied");
					
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception{
		builder.userDetailsService(professeurService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
//	
	@Bean
	public SecurityContextHolderAwareRequestFilter awareRequestFilter(){
		return new SecurityContextHolderAwareRequestFilter();
	}
	
	@Bean
	public SecurityContextPersistenceFilter persistenceFilter() {
		return new SecurityContextPersistenceFilter();
	}
}
