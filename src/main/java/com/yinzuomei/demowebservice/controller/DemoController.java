package com.yinzuomei.demowebservice.controller;

import com.yinzuomei.demowebservice.dto.*;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import com.yinzuomei.demowebservice.service.DemoService;
import com.yinzuomei.demowebservice.utils.ExcelUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @Description 测试接口Demo
 * @Author yinzuomei
 * @Date 2020/1/13 11:07
 */
@RestController
@RequestMapping("demo")
@Api(value="demo",description= "用户信息管理（demo）")
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
	@ApiOperation(value = "保存用户信息",response = Result.class )
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
	@PostMapping("delete")
	@ApiOperation(value = "根据主键删除记录", notes = "",response = Result.class )
	public Result delete(@RequestParam(required = true) @ApiParam(value = "主键", required = true) @PathParam("id")int id) {
		return demoService.delete(id);
	}

	/**
	 * @param formDTO
	 * @return com.yinzuomei.demowebservice.dto.Result
	 * @Author yinzuomei
	 * @Description 修改
	 * @Date 2020/1/13 14:33
	 **/
	@ApiOperation(value = "修改", notes = "",response = Result.class )
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
	@ApiOperation(value = "根据姓名模糊查询", notes = "name可传空",response = Result.class)
	public Result<List<DemoEntity>> query(@RequestParam(required = true) @ApiParam(name="name",value="用户姓名",required=true) String name) {
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
	@ApiOperation(value = "导出未删除用户列表", notes = "",response = Result.class )
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
	@ApiOperation(value = "批量导入用户信息", notes = "",response = Result.class )
	public Result<List<DemoImportEntity>> importExcel(@RequestParam("file")@ApiParam(name="file",value="文件",required=true) MultipartFile file) {
		return demoService.importExcel(file);
	}
}
