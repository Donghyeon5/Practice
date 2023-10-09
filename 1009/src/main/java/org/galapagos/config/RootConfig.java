package org.galapagos.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.galapagos.sample"})
@MapperScan(basePackages = {"org.galapagos.mapper"})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
	HikariConfig config = new HikariConfig();
//	config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	config.setJdbcUrl("jdbc:mysql://localhost:3306/glory_db");
	
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
	sqlSessionFactory.setDataSource(dataSource());
	return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
}
