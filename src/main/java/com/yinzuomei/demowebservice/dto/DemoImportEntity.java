package com.yinzuomei.demowebservice.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/13 16:20
 */
@Data
public class DemoImportEntity {
	@Excel(name = "姓名", orderNum = "0")
	private String name;
	@Excel(name = "年龄", orderNum = "1")
	private int age;
	@Excel(name = "时间", orderNum = "2")
	private Date date;

	public DemoImportEntity(){
		this.name=name;
		this.age=age;
		this.date=date;
	}

}
