package org.beckoning.web.loading.mybatis;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = DataConfigure.PACKBASE, sqlSessionFactoryRef = DataConfigure.SQLSESSIONFACTORY)
public class DataConfigure {
	
	//需要映射的接口bao路径
	static final String PACKBASE = "org.beckoning.web.loading.management.mapper";
	//配置文件字段前缀
	static final String PREFIX = "database";
	//配置文件路径
	static final String LOCATION = "classpath:spring/dataConfig.properties";
	//数据配置名
	static final String RESOURCE = "DataResource";
	//数据源名
	static final String DATASOURCE = "DataSource";
	//事务名
	static final String TRANSACTION = "TransactionManager";
	//mybatis sqlsession factory 名
	static final String SQLSESSIONFACTORY = "SqlSessionFactory";
	
	/**
	 * 初始化数据源配置
	 * @return
	 */
	@Bean(RESOURCE)
    @ConfigurationProperties(prefix = PREFIX,locations = {LOCATION})
    public DataResource DataResource(){
       return new DataResource();
    }
	
	/**
	 * 初始化连接池配置
	 * @param dataResource
	 * @return
	 * @throws SQLException
	 */
	@Bean(DATASOURCE)
	public DataSource DataSource(@Qualifier(RESOURCE)DataResource dataResource) throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(dataResource.getDriverClass());
		dataSource.setUrl(dataResource.getJdbcUrl());
		dataSource.setUsername(dataResource.getUsername());
		dataSource.setPassword(dataResource.getPassword());
		dataSource.setFilters(dataResource.getFilters());
		dataSource.setInitialSize(dataResource.getInitialSize());
		dataSource.setMaxActive(dataResource.getMaxActive());
		dataSource.setMinIdle(dataResource.getMinIdle());
		dataSource.setMaxWait(dataResource.getMaxWait());
		dataSource.setTimeBetweenEvictionRunsMillis(dataResource.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(dataResource.getMinEvictableIdleTimeMillis());
		dataSource.setValidationQuery(dataResource.getValidationQuery());
		dataSource.setTestWhileIdle(dataResource.isTestWhileIdle());
		dataSource.setTestOnReturn(dataResource.isTestOnReturn());
		dataSource.setTestOnBorrow(dataResource.isTestOnBorrow());
		dataSource.setPoolPreparedStatements(dataResource.isPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(dataResource.getMaxPoolPreparedStatementPerConnectionSize());
		dataSource.setRemoveAbandoned(dataResource.isRemoveAbandoned());
		dataSource.setRemoveAbandonedTimeout(dataResource.getRemoveAbandonedTimeout());
		return dataSource;
	}

	/**
	 * 初始化事务配置
	 * @param dataSource
	 * @return
	 */
	@Bean(name = TRANSACTION)
	public DataSourceTransactionManager TransactionManager(@Qualifier(DATASOURCE) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * 初始化mapper.xml配置
	 * @param dataSource
	 * @param dataResource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = SQLSESSIONFACTORY)
	public SqlSessionFactory SqlSessionFactory(@Qualifier(DATASOURCE) DataSource dataSource,@Qualifier(RESOURCE) DataResource dataResource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(dataResource.resolveMapperLocations());
		return sessionFactory.getObject();
	}
}
