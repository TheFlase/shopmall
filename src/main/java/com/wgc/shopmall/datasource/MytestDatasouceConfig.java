package com.wgc.shopmall.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/26/2020
 **/
@Configuration
@MapperScan(basePackages = {"com.wgc.shopmall.dao"},sqlSessionTemplateRef = "myTestSqlSessionTemplate")
public class MytestDatasouceConfig {
    @Bean(name = "myTestDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.mytest")
    public DataSource mytestDataSource() {
        return DruidDataSourceBuilder.create().build();
//        return DataSourceBuilder.create().build();
    }

    @Bean(name = "myTestSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("myTestDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/mytest/*.xml"));
        return factoryBean.getObject();
    }
    @Bean(name="myTestTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("myTestDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "myTestSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("myTestSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
