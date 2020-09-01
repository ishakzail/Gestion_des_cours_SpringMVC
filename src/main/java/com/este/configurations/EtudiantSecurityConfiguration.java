package com.este.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;



import com.este.service.EtudiantService;

@EnableWebSecurity
@Configuration
@Order(4)

public class EtudiantSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private EtudiantService etudiantService;
	
	
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.cors().and().csrf().disable();
		
		httpSecurity.antMatcher("/etudiant/**")
					.authorizeRequests()
					.antMatchers("/etudiant/**").access("hasRole('ROLE_ETUDIANT')")
					.and()
					.formLogin()
					.loginPage("/etudiant-panel")
					.loginProcessingUrl("/etudiant/process-login")
					.defaultSuccessUrl("/etudiant-panel/welcome")
					.failureUrl("/etudiant-panel/login?error")
					.usernameParameter("email").passwordParameter("motdepass")
					.and()
					.logout()
					.logoutUrl("/etudiant/process-logout")
					.logoutSuccessUrl("/etudiant-panel/login?logout")
					.deleteCookies("JSESSIONID")
					.and()
					.exceptionHandling().accessDeniedPage("/etudiant-panel/accesDenied");
					
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception{
		builder.userDetailsService(etudiantService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityContextHolderAwareRequestFilter awareRequestFilter(){
		return new SecurityContextHolderAwareRequestFilter();
	}
	
	@Bean
	public SecurityContextPersistenceFilter persistenceFilter() {
		return new SecurityContextPersistenceFilter();
	}
}
