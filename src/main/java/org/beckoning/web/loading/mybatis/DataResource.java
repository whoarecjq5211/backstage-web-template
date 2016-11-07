package org.beckoning.web.loading.mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class DataResource {
	private boolean poolPreparedStatements;
	private boolean removeAbandoned;
	private String driverClass;
	private String jdbcUrl;
	private String username;
	private String password;
	private String filters;
	private int initialSize;
	private int maxActive;
	private int minIdle;
	private int maxWait;
	private int timeBetweenEvictionRunsMillis;
	private int minEvictableIdleTimeMillis;
	private String validationQuery;
	private boolean testWhileIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private int maxPoolPreparedStatementPerConnectionSize;
	private String connectionInitSqls;
	private int removeAbandonedTimeout;
	private String[] mapperLocations;
	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}
	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}
	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}
	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFilters() {
		return filters;
	}
	public void setFilters(String filters) {
		this.filters = filters;
	}
	public int getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	public String getValidationQuery() {
		return validationQuery;
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}
	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}
	public String getConnectionInitSqls() {
		return connectionInitSqls;
	}
	public void setConnectionInitSqls(String connectionInitSqls) {
		this.connectionInitSqls = connectionInitSqls;
	}
	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}
	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}
	public String[] getMapperLocations() {
		return mapperLocations;
	}
	public void setMapperLocations(String[] mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyProperties3 [poolPreparedStatements=").append(poolPreparedStatements)
				.append(", removeAbandoned=").append(removeAbandoned).append(", driverClass=").append(driverClass)
				.append(", jdbcUrl=").append(jdbcUrl).append(", username=").append(username).append(", password=")
				.append(password).append(", filters=").append(filters).append(", initialSize=").append(initialSize)
				.append(", maxActive=").append(maxActive).append(", minIdle=").append(minIdle).append(", maxWait=")
				.append(maxWait).append(", timeBetweenEvictionRunsMillis=").append(timeBetweenEvictionRunsMillis)
				.append(", minEvictableIdleTimeMillis=").append(minEvictableIdleTimeMillis).append(", validationQuery=")
				.append(validationQuery).append(", testWhileIdle=").append(testWhileIdle).append(", testOnBorrow=")
				.append(testOnBorrow).append(", testOnReturn=").append(testOnReturn)
				.append(", maxPoolPreparedStatementPerConnectionSize=")
				.append(maxPoolPreparedStatementPerConnectionSize).append(", connectionInitSqls=")
				.append(connectionInitSqls).append(", removeAbandonedTimeout=").append(removeAbandonedTimeout)
				.append(", mapperLocations=")
				.append(mapperLocations != null
						? Arrays.asList(mapperLocations).subList(0, Math.min(mapperLocations.length, maxLen)) : null)
				.append("]");
		return builder.toString();
	}
	
	public Resource[] resolveMapperLocations() {
		List<Resource> resources = new ArrayList<Resource>();
		if (this.mapperLocations != null) {
			for (String mapperLocation : this.mapperLocations) {
				Resource[] mappers;
				try {
					mappers = new PathMatchingResourcePatternResolver().getResources(mapperLocation);
					resources.addAll(Arrays.asList(mappers));
				} catch (IOException e) {

				}
			}
		}

		Resource[] mapperLocations = new Resource[resources.size()];
		mapperLocations = resources.toArray(mapperLocations);
		return mapperLocations;
	}
}
