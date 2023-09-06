package org.galapagos.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.galapagos.sample"})
@MapperScan(basePackages = {"org.galapagos.mapper"})
public class RootConfig {
	@Bean //이 메서드의 리턴값이 bean으로 등록
		public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
// 		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
// 		config.setJdbcUrl("jdbc:mysql://localhost:3306/glory_db");
		
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/glory_db");
		
		config.setUsername("glory");
		config.setPassword("1234");
		
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	@Bean
		public SqlSessionFactory sqlSessionFactory() throws Exception {
			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			// SqlSessionFactoryBean 생성	
			
		sqlSessionFactory.setDataSource(dataSource()); 
			// dataSource라는 메서드 호출 (이미 위에서 호출됨 , 한번 더 호출 시 싱글톤 X )
			// @Configuration + @Bean 의 메서드를 재호출하면 그 메서드가 등록한 bean을 달라는 뜻
			return (SqlSessionFactory) sqlSessionFactory.getObject();
		}
}
