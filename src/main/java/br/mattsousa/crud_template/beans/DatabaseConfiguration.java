package br.mattsousa.crud_template.beans;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    private Logger logger = Logger.getLogger(DatabaseConfiguration.class.getName());

    @Autowired
    private AppProperties appProperties;
    
    @Bean
    DataSource dataSource() {
        logger.info("Create DataSource Bean");
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        return builder
            .url(appProperties.getUrl())
            .username(appProperties.getUsername())
            .password(appProperties.getPassword())
            .driverClassName(appProperties.getDriverClassName())
            .build();
    }
}
