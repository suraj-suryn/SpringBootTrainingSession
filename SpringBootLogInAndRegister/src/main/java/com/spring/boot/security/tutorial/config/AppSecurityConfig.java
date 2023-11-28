package com.spring.boot.security.tutorial.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override

	@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		UserDetails u1 = User.withDefaultPasswordEncoder().username("sam").password("sam").roles("USER").build();
		UserDetails u2 = User.withDefaultPasswordEncoder().username("jack").password("jack").roles("USER").build();
		UserDetails u3 = User.withDefaultPasswordEncoder().username("mick").password("mick").roles("ADMIN").build();
		UserDetails u4 = User.withDefaultPasswordEncoder().username("anny").password("anny").roles("ADMIN").build();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		return new InMemoryUserDetailsManager(users);
	}

	public AuthenticationProvider oathProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		provider.setUserDetailsService(userDetailsService);
		return provider;

	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic(); }
	 */

	/*
	 * @Override
	 * 
	 * @Bean protected UserDetailsService userDetailsService() { List<UserDetails>
	 * users = new ArrayList<>(); UserDetails u1 =
	 * User.withDefaultPasswordEncoder().username("sam").password("sam").roles(
	 * "USER").build(); UserDetails u2 =
	 * User.withDefaultPasswordEncoder().username("jack").password("jack").roles(
	 * "USER").build(); UserDetails u3 =
	 * User.withDefaultPasswordEncoder().username("mick").password("mick").roles(
	 * "ADMIN").build(); UserDetails u4 =
	 * User.withDefaultPasswordEncoder().username("anny").password("anny").roles(
	 * "ADMIN").build(); users.add(u1); users.add(u2); users.add(u3); users.add(u4);
	 * return new InMemoryUserDetailsManager(users); }
	 */

}
