package kr.or.connect.reservation2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.reservation2.dao",  "kr.or.connect.reservation2.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}