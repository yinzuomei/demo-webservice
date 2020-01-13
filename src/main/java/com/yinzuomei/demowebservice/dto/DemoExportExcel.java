package com.yinzuomei.demowebservice.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author yinzuomei
 * @Date 2020/1/13 15:57
 */
@Data
public class DemoExportExcel {
	@Excel(name = "主键", orderNum = "0")
	private int id;

	@Excel(name = "姓名", orderNum = "1")
	private String name;

	@Excel(name = "年龄", orderNum = "2")
	private int age;

	@Excel(name = "创建时间", orderNum = "3",exportFormat = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;

	@Excel(name = "删除标志", replace = {"已删除_1", "未删除_0"},orderNum = "4")
	private String delFlag;

	@Excel(name = "更新时间", orderNum = "5",exportFormat = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

}
