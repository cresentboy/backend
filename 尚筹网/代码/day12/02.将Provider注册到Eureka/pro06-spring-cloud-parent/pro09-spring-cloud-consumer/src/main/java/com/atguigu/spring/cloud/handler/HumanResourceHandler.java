package com.atguigu.spring.cloud.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class HumanResourceHandler {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/get/employee")
	public Employee getEmployeeRemote() {
		
		// 1.声明远程微服务的主机地址加端口号
		String host = "http://localhost:1000";
		
		// 2.声明具体要调用的功能的URL地址
		String url =  "/provider/get/employee/remote";
		
		// 3.通过RestTemplate调用远程微服务
		return restTemplate.getForObject(host + url, Employee.class);
	}

}
