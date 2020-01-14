package com.yinzuomei.demowebservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @Description demo
 * @Author yinzuomei
 * @Date 2020/1/13 13:25
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="user1111" )
public class DemoEntity {

	@XmlElement(required = true)
	private int id;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;

	@XmlElement(required = true)
	private String delFlag;

	@XmlElement(required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	@XmlElement(required = true)
	private int age;
}
