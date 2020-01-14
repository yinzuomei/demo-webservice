package com.yinzuomei.demowebservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Auther: yinzuomei
 * @Date: 2020/1/14 10:36
 * @Description:
 */
//  命名空间，写一个有意义的http地址就行，并不是网上所说的要写成包名倒序,只不过写成包名倒序易读而已
@WebService(name = "DemoWebService", targetNamespace = "http://service.demowebservice.yinzuomei.com")
public interface DemoWebService {
	/**
	 * @param Request
	 * @return java.lang.String
	 * @Author yinzuomei
	 * @Description
	 * @Date 2020/1/14 14:01
	 **/
	@WebMethod
	String test(@WebParam(name = "Request") String Request);
}
