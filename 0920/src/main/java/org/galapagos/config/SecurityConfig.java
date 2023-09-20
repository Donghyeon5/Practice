package org.galapagos.config;

import javax.sql.DataSource;

import org.galapagos.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.log4j.Log4j;



@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public CustomUserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			// 모두 허용
			.antMatchers("/security/all").permitAll()
			// 특정 역할에게만 허용
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");
		
		http.formLogin()
			.loginPage("/security/login")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/")
			// 로그인 실패시 이동할 url 설정
			.failureUrl("/security/login?error=true");
		
		http.logout() // 로그아웃 설정 시작
			.logoutUrl("/security/logout") // POST: 로그아웃 호출 url
			.invalidateHttpSession(true) // 세션 invalidate
			.deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
			.logoutSuccessUrl("/"); // 로그아웃 이후 이동할 페이지
		
		http.rememberMe() // remember-me 기능 설정
		.key("Galapagos")
		.tokenRepository(persistentTokenRepository())
		.tokenValiditySeconds(7*24*60*60); // 7일
		
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
	JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
	repo.setDataSource(dataSource);
	return repo;
	}
	
	// id와 pw가 어떻게 되는지
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		log.info("configure .........................................");
		
		auth.inMemoryAuthentication() // 메모리에서 사용자 정보 설정
			.withUser("admin") // username, 사용자 id
//			.password("{noop}1234") // 비밀번호, {noop}는 암호화 없음 의미
			.password("$2a$10$uvcLi9AdW3GI6JUm8Er8YupPIrI5Mr0ElhLTVw5EaQ5rNdfRM71JG") 
			
			.roles("ADMIN"); // 역할 설정

		auth.inMemoryAuthentication()
			.withUser("member")
//			.password("{noop}1234")
			
			// 암호화상태 직접 입력함 
			.password("$2a$10$uvcLi9AdW3GI6JUm8Er8YupPIrI5Mr0ElhLTVw5EaQ5rNdfRM71JG")
			.roles("MEMBER");	
		
		
		auth
		.userDetailsService(customUserService())
		.passwordEncoder(passwordEncoder());
		
		
		
		
	}
	

	
}
