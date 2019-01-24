package com.saral.reporting.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationService authenticationService;

	private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/image/**", "/welcome", "/DesignReptPage",
			"/fetchReportList", "/DesignReport", "/DesignReportCol", "/fetchReportName", "/fetchReportName/**", "/havingfunctionslist" ,"/viewSelectedReport/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).access("hasRole('ROLE_DHE')  or hasRole('ROLE_GO')  ")
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome")

				.usernameParameter("sign_no").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/login?logout");

		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).access("hasRole('ROLE_DHEAD')  or hasRole('ROLE_GOVT')  ")
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/login?error")

				.usernameParameter("sign_no").passwordParameter("password");

		http.csrf().disable();

	}

	@Autowired
	public void GlobalConfigure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService);

	}

}
