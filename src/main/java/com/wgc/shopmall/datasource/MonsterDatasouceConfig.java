package com.wgc.shopmall.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/26/2020
 **/
@Configuration
@MapperScan(basePackages = {"com.wgc.shopmall.dao.monster"},sqlSessionTemplateRef = "monsterSqlSessionTemplate")
public class MonsterDatasouceConfig {
    @Bean(name = "monsterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.monster")
    public DataSource monsterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "monsterSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("monsterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/monster/*.xml"));
        return factoryBean.getObject();
    }
    @Bean(name="monsterTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("monsterDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "monsterSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("monsterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
