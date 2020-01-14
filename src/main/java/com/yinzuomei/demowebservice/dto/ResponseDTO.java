package com.yinzuomei.demowebservice.dto;

import com.yinzuomei.demowebservice.config.JaxbDateSerializer;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/14 14:06
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="Response" )
public class ResponseDTO implements Serializable {
	@XmlAttribute
	private String id;

	@XmlElement(required = true)
	private String resultCode;

	@XmlElement(required = true)
	private String message;

	@XmlElement(required = true)
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date responseTime;

	@XmlElementWrapper(name = "users")
	@XmlElement(name="user",required = true)
	private List<DemoEntity> list;

	public ResponseDTO(){
		this.id="test";
		this.resultCode="1";
		this.message="调用成功";
		this.responseTime=new Date();
		this.list=new ArrayList<>();
	}
}
