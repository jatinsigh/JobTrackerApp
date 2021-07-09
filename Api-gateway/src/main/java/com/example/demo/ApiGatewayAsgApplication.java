package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.ErrorFilter;
import com.example.demo.filters.PostFilter;
import com.example.demo.filters.PreFilter;
import com.example.demo.filters.RouterFilter;

@EnableZuulProxy
@RefreshScope
@Configuration
@SpringBootApplication
public class ApiGatewayAsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayAsgApplication.class, args);
	}

//	@Bean
	public PreFilter myFilter() {
		return new PreFilter();
	}

//	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

//	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

//	@Bean
	public RouterFilter routerFilter() {
		return new RouterFilter();
	}

}
