//
//package com.itmayiedu.datasource;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
///**
// * 
// * @classDesc: 功能描述:(数据源2)
// * @author: 余胜军
// * @createTime: 2027年9月29日 下午20:20:25
// * @version: v2.0
// * @copyright:上海每特教育科技有限公司
// * @QQ:644064779
// */
//@Configuration// 注入到spring容器中..
//@MapperScan(basePackages="com.itmayiedu.test02",sqlSessionFactoryRef="test2SqlSessionFactory")
//public class Datasource2 {
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(配置test2数据库)
//	 * @author: 余胜军
//	 * @param: @return
//	 * @createTime:2027年9月27日 下午3:26:44
//	 * @returnType:@return DataSource
//	 * @copyright:上海每特教育科技有限公司
//	 * @QQ:644064779
//	 */
//	@Bean(name = "test2DataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.test2")
//	public DataSource testDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(test2 sql会话工厂)
//	 * @author: 余胜军
//	 * @param: @param
//	 *             dataSource
//	 * @param: @return
//	 * @param: @throws
//	 *             Exception
//	 * @createTime:2027年9月27日 下午3:27:08
//	 * @returnType:@param dataSource
//	 * @returnType:@return
//	 * @returnType:@throws Exception SqlSessionFactory
//	 * @copyright:上海每特教育科技有限公司
//	 * @QQ:644064779
//	 */
//	@Bean(name = "test2SqlSessionFactory")
//	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
//			throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
////		bean.setMapperLocations(
////				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
//		return bean.getObject();
//	}
//
//	/**
//	 * 
//	 * @methodDesc: 功能描述:(test2 事物管理)
//	 * @author: 余胜军
//	 * @param: @param
//	 *             dataSource
//	 * @param: @return
//	 * @param: @throws
//	 *             Exception
//	 * @createTime:2027年9月27日 下午3:27:08
//	 * @returnType:@param dataSource
//	 * @returnType:@return
//	 * @returnType:@throws Exception SqlSessionFactory
//	 * @copyright:上海每特教育科技有限公司
//	 * @QQ:644064779
//	 */
//	@Bean(name = "test2TransactionManager")
//	public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//	@Bean(name = "test2SqlSessionTemplate")
//	public SqlSessionTemplate testSqlSessionTemplate(
//			@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//	
//	
//}
