package com.yinzuomei.demowebservice.service.impl;

import com.yinzuomei.demowebservice.dao.DemoDao;
import com.yinzuomei.demowebservice.dto.ResponseDTO;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import com.yinzuomei.demowebservice.service.DemoWebService;
import com.yinzuomei.demowebservice.utils.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/14 13:24
 */
@WebService(serviceName = "DemoWebService",
		targetNamespace = "http://service.demowebservice.yinzuomei.com",
		endpointInterface = "com.yinzuomei.demowebservice.service.DemoWebService")
@Component
public class DemoWebServiceImpl implements DemoWebService {
	@Autowired
	private DemoDao demoDao;

	@Override
	public String test(String Request) {
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setMessage("入参Request="+Request);
		List<DemoEntity> list = demoDao.query(null);
		responseDTO.setList(list);
		return JaxbUtil.convertToXml(responseDTO);
	}
}
