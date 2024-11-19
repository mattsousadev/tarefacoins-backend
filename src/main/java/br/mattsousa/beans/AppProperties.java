package br.mattsousa.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    
}
