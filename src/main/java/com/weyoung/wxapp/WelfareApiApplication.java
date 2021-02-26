package com.weyoung.wxapp;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.weyoung.wxapp.common.config.FebsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableSwagger2Doc
@MapperScan("com.weyoung.wxapp.*.dao")
@EnableConfigurationProperties({FebsProperties.class})
@EnableAsync
@EnableTransactionManagement
public class WelfareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelfareApiApplication.class, args);
	}
}
