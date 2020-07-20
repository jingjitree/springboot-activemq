package top.inson.core;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "top.inson.dao")
public class MPConfiguration {



}
