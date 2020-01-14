package com.yinzuomei.demowebservice.config;

import org.springframework.context.annotation.Configuration;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/14 15:21
 */
@Configuration
public class JaxbDateSerializer  extends XmlAdapter<String, Date> {
	@Override
	public Date unmarshal(String v) throws Exception {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 // 避免线程不安全，这里使用局部变量，而非全局变量
		return dateformat.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		SimpleDateFormat  dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateformat.format(v);
	}
}
