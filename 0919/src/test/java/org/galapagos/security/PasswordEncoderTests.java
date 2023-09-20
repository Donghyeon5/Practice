package org.galapagos.security;

import org.galapagos.config.RootConfig;
import org.galapagos.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,
		SecurityConfig.class
})

@Log4j
public class PasswordEncoderTests {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncode() {
		String str = "1234";
		
		String enStr = pwEncoder.encode(str);
		log.info("password : " + enStr);
		
		String enStr2 = pwEncoder.encode(str);
		log.info("passwrod: " + enStr2);
		
		// str -> 사용자 입력값, enStr -> DB 저장된 값 일치하는지 matches로 확인
		log.info("match :" + pwEncoder.matches(str, enStr));
		log.info("match :" + pwEncoder.matches(str, enStr2));
	}
	
	
	
}