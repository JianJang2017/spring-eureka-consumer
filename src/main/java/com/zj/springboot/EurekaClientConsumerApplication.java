package com.zj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 通过@EnableDiscoveryClient注解让该应用注册为Eureka客户端应用，以获得服务发现的能力
 * @author lenovo
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientConsumerApplication {
	/**
	 * 创建RestTemplate的spring bean 实例
	 * 开启客户端负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumerApplication.class, args);
	}
}
