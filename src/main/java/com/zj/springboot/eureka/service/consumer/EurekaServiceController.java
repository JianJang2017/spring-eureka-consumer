package com.zj.springboot.eureka.service.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaServiceController {
	private Logger logger = LoggerFactory.getLogger(EurekaServiceController.class);
	/**
	 * 通过服务名称进行调用：在Eureka服务器上注册的服务名称不区分大小写
	 */
	@Value("${service.url}")
	private String SERVICE_URL;
	@Autowired
	private  RestTemplate restTemplate;
	@GetMapping("/call")
	public String callSayHello(){
		logger.info("restTemplate:{}",restTemplate);
		return restTemplate.getForEntity(SERVICE_URL, String.class).getBody();
	}

}
