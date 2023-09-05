package org.galapagos.sample;

import static org.junit.Assert.*;

import org.galapagos.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.galapagos.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j // 콘솔에서 확인하기 위함
public class SampleTests {
	
//	@Setter(onMethod_ = { @Autowired})
//	private Restaurant restaurant;
	@Autowired // reflection 기능을 이용하여 설정, 멤버변수의 설정
	private Restaurant restaurant;
	
	@Test
	public void test() {
		
		assertNotNull(restaurant);
		//restaurant이 null이 아님을 검사, 뭔가 주입이 됐다는 뜻
		
		//toString 검사
		log.info(restaurant);
		log.info("-------------------------");
		log.info(restaurant.getChef());
	
	}

}
