package com.yinzuomei.demowebservice.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author yinzuomei
 * @Date 2020/1/13 14:09
 */
@Data
public class DemoSaveFormDTO implements Serializable {
	@NotBlank(message = "name不能为空")
	private String name;
	@Min(1)
	private int age;
	private Date createdTime;

	private String delFlag;
}
