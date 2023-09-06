package org.galapagos.persistence;

import static org.junit.Assert.fail;
import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.galapagos.config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class DataSourceTests {
	@Autowired //등록되있는 beans 중에서 해당 타입(키)에 맞는것 찾아주세요
	private DataSource dataSource; //의존 객체
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			log.info(con); // INFO(정보의 종류) : 어느 클래스에서 나온 로그인지
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();	
	){
			
			log.info(session);
			log.info(con);
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
