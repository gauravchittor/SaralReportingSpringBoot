package com.saral.reporting.domain.security;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationService authenticationService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").access("hasRole('ROLE_DHE')  or hasRole('ROLE_GO')  ")
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome")

				.usernameParameter("sign_no").passwordParameter("password");
		
		
		http.authorizeRequests().antMatchers("/welcome").access("hasRole('ROLE_DHEAD')  or hasRole('ROLE_GOVT')  ")
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome")

		.usernameParameter("sign_no").passwordParameter("password");

		http.csrf().disable();

	}

	@Autowired
	public void GlobalConfigure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService);

	}

}
