package com.yinzuomei.demowebservice.controller;

import com.yinzuomei.demowebservice.dto.*;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import com.yinzuomei.demowebservice.service.DemoService;
import com.yinzuomei.demowebservice.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description 测试接口Demo
 * @Author yinzuomei
 * @Date 2020/1/13 11:07
 */
@RestController
@RequestMapping("demo")
public class DemoController {
	@Autowired
	private DemoService demoService;

	/**
	 * @param formDTO
	 * @return com.yinzuomei.demowebservice.dto.Result
	 * @Author yinzuomei
	 * @Description 新增一条记录
	 * @Date 2020/1/13 14:34
	 **/
	@PostMapping("save")
	public Result save(@RequestBody @Valid DemoSaveFormDTO formDTO) {
		return demoService.save(formDTO);
	}

	/**
	 * @param id
	 * @return com.yinzuomei.demowebservice.dto.Result
	 * @Author yinzuomei
	 * @Description 根据主键删除记录
	 * @Date 2020/1/13 14:34
	 **/
	@PostMapping("delete/{id}")
	public Result delete(@PathVariable("id") int id) {
		return demoService.delete(id);
	}

	/**
	 * @param formDTO
	 * @return com.yinzuomei.demowebservice.dto.Result
	 * @Author yinzuomei
	 * @Description 修改
	 * @Date 2020/1/13 14:33
	 **/
	@PostMapping("update")
	public Result update(@RequestBody @Valid DemoUpdateFormDTO formDTO) {
		return demoService.update(formDTO);
	}

	/**
	 * @param name
	 * @return com.yinzuomei.demowebservice.dto.Result<java.util.List < com.yinzuomei.demowebservice.entity.DemoEntity>>
	 * @Author yinzuomei
	 * @Description 查
	 * @Date 2020/1/13 14:33
	 **/
	@GetMapping("query")
	public Result<List<DemoEntity>> query(@RequestParam("name") String name) {
		return demoService.query(name);
	}

	/**
	 * @param response
	 * @return void
	 * @Author yinzuomei
	 * @Description 下载excel
	 * @Date 2020/1/13 21:25
	 **/
	@GetMapping("/downloadExcel")
	public void export(HttpServletResponse response) {
		List<DemoExportExcel> list = demoService.queryAll();
		//导出到Excel
		ExcelUtils.exportExcel(list, "用户列表", "sheet1", DemoExportExcel.class, +System.currentTimeMillis() + ".xls", response);
	}

	/**
	 * @param file
	 * @return com.yinzuomei.demowebservice.dto.Result<java.util.List < com.yinzuomei.demowebservice.dto.DemoImportEntity>>
	 * @Author yinzuomei
	 * @Description 导入excel, 将数据存储到demo表
	 * @Date 2020/1/13 21:25
	 **/
	@PostMapping("importExcel")
	public Result<List<DemoImportEntity>> importExcel(@RequestParam("file") MultipartFile file) {
		return demoService.importExcel(file);
	}
}
