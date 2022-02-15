package cn.geekhall.sbdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * MyDataSourceConfig
 *
 * @author yiny
 */
@Configuration
public class MyDataSourceConfig {

    // 默认的自动配置是判断容器中没有配置数据源才会进行配置
    // 默认使用Hikari数据源
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        下面这种方式不太合适，一般不直接在源码中配置使用，
//        而使用@ConfigurationProperties("spring.datasource")
//        String url;
//        String username;
//        String password;
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
