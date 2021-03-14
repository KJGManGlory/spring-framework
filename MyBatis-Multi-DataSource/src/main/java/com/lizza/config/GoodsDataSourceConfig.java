package com.lizza.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lizza.dao.goods.GoodsDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 1. Spring 引入配置文件: https://blog.csdn.net/wb785074651/article/details/105446933
 * 2. 多数据源配置: https://blog.csdn.net/taojin12/article/details/88399177
 */
@Configuration
@MapperScan(basePackageClasses = GoodsDao.class,
            sqlSessionTemplateRef  = "goodsSqlSessionTemplate")
public class GoodsDataSourceConfig {

    @Value("${goods.jdbc.url}")
    private String url;

    @Value("${goods.jdbc.username}")
    private String username;

    @Value("${goods.jdbc.password}")
    private String password;

    @Bean
    public DataSource goodsDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory goodsSqlSessionFactory(DataSource goodsDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(goodsDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/GoodsMapper.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager goodsTransactionManager(DataSource goodsDataSource) {
        return new DataSourceTransactionManager(goodsDataSource);
    }

    @Bean
    public SqlSessionTemplate goodsSqlSessionTemplate(SqlSessionFactory goodsSqlSessionFactory) {
        return new SqlSessionTemplate(goodsSqlSessionFactory);
    }
}
