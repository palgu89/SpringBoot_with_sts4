package com.myweb.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties") // 안써도 자동으로 읽긴 하는데 mybatis를 연동해야 하기 때문에 적음 (jpa는 자동)
public class DatabaseConfiguration {

		@Autowired
		private ApplicationContext applicationContext;	// ApplicationContext은 spring걸로 import
		
		@Value("${mybatis.mapper-locations}")
		private String mapperLocations;
		
		@Bean
		@ConfigurationProperties(prefix = "spring.datasource")	//application.properties랑 매치해보자. 밑에도
		public HikariConfig hikariConfig() {
			return new HikariConfig();
		}
		
		@Bean
		public org.apache.ibatis.session.Configuration mybatisConfig(){
			return new org.apache.ibatis.session.Configuration();
		}
		
		@Bean
		public DataSource dataSource() throws Exception{
			DataSource dataSource = new HikariDataSource(hikariConfig());
			return dataSource;
		}
		
		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();	// sql 객체 생성
			sqlSessionFactoryBean.setDataSource(dataSource);	// dataSource 정보 추가
			sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mappers/mybatis-config.xml"));	// mybatis 설정 정보 위치값 추가
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));	// mybatis mapper 정보 위치값 추가
			return sqlSessionFactoryBean.getObject();	// sqlSession 객체 return
		}
		
		@Bean
		public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
}
