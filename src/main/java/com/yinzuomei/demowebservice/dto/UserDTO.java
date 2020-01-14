package com.yinzuomei.demowebservice.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.apache.catalina.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/14 15:35
 */
@Data
@XStreamAlias("user")
public class UserDTO implements Serializable {
	@XStreamAlias("ID")
	private int id;
	@XStreamAlias("NAME")
	private String name;
	@XStreamAlias("DATE")
	private Date insertDate;
	@XStreamAlias("NUM")
	private BigDecimal num;

	public UserDTO(){

	}
	public UserDTO(int id,String name,Date nowDate,BigDecimal num){
		this.id=id;
		this.name=name;
		this.insertDate=nowDate;
		this.num=num;
	}
}
