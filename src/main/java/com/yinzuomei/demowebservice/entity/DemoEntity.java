package com.yinzuomei.demowebservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description demo
 * @Author yinzuomei
 * @Date 2020/1/13 13:25
 */
@Data
public class DemoEntity {
	private int id;
	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;
	private String delFlag;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	private int age;
}
