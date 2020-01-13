package com.yinzuomei.demowebservice.service.impl;

import com.yinzuomei.demowebservice.dao.DemoDao;
import com.yinzuomei.demowebservice.dto.*;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import com.yinzuomei.demowebservice.service.DemoService;
import com.yinzuomei.demowebservice.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Description DemoImpl
 * @Author yinzuomei
 * @Date 2020/1/13 11:08
 */
@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	private DemoDao demoDao;
	@Override
	public Result<List<DemoEntity>> query(String name) {
		List<DemoEntity> list=demoDao.query(name);
		return new Result<List<DemoEntity>>().ok(list);
	}

	@Override
	public Result delete(int id) {
		demoDao.delete(id);
		return new Result();
	}

	@Override
	public Result update(DemoUpdateFormDTO formDTO) {
		formDTO.setUpdateTime(new Date());
		demoDao.update(formDTO);
		return new Result();
	}

	@Override
	public Result save(DemoSaveFormDTO formDTO) {
		formDTO.setCreatedTime(new Date());
		demoDao.save(formDTO);
		return new Result();
	}

	@Override
	public List<DemoExportExcel> queryAll() {
		return demoDao.queryAll();
	}

	@Override
	public Result<List<DemoImportEntity>> importExcel(MultipartFile file) {
		List<DemoImportEntity> list= ExcelUtils.importExcel(file,  0,  1, DemoImportEntity.class);
		System.out.println("总共几条记录"+list.size());
		for(DemoImportEntity entity:list){
			DemoSaveFormDTO formDTO=new DemoSaveFormDTO();
			formDTO.setCreatedTime(entity.getDate());
			formDTO.setAge(entity.getAge());
			formDTO.setName(entity.getName());
			demoDao.save(formDTO);
		}
		return new Result<List<DemoImportEntity>>().ok(list);
	}


}
