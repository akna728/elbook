package com.example.demo.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web	.ignoring()
			.antMatchers("/images/**", "/css/**", "/js/**");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// htmlファイルを指定しているのではなく、リクエストURL
		
//		http.authorizeRequests().mvcMatchers("/login/**", "/index/showsignup", "/user.signupuser").permitAll()
//			.and()
//			.authorizeRequests().mvcMatchers("/user/**").hasAuthority("ADMIN").anyRequest().authenticated()
//			.and()
//			.formLogin().loginPage("/login")
//			.and()
//			.formLogin().defaultSuccessUrl("/book/list");
//		http.exceptionHandling().accessDeniedPage("/error");
		
		http.authorizeRequest()
			.antMatchers("/images/**", "/css/**", "/js/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password").permitAll()
			.and()
			.logout().logoutUrl("/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder Security) throws Exception {
		
		Security
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
		
	}

}
