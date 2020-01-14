package com.yinzuomei.demowebservice.config;

import com.yinzuomei.demowebservice.service.DemoWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2019/12/30 12:55
 */
@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	@Autowired
	private DemoWebService demoWebService;

	@Bean
	public Endpoint endpointUserService() {
		EndpointImpl endpoint = new EndpointImpl(bus,demoWebService);
		endpoint.publish("/webservices");//接口发布在 /webservices 目录下
		return endpoint;
	}

}
