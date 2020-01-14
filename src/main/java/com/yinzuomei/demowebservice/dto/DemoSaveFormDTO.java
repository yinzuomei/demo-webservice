package com.yinzuomei.demowebservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="DemoSaveFormDTO",description="保存用户信息入参DTO")
public class DemoSaveFormDTO implements Serializable {

	@ApiModelProperty(value="姓名",name="name",example="张三",required = true)
	@NotBlank(message = "name不能为空")
	private String name;


	@Min(1)
	@ApiModelProperty(value="年龄",name="age",example="20",required = true)
	private int age;

	@ApiModelProperty(value="插入时间默认当前时间",name="createdTime",required = false)
	private Date createdTime;

	@ApiModelProperty(value="删除标志默认为0",name="delFlag",example="0",required = false)
	private String delFlag;
}
