package com.yinzuomei.demowebservice.service;

import com.yinzuomei.demowebservice.dto.*;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: yinzuomei
 * @Date: 2020/1/13 11:08
 * @Description: 测试DemoService
 */
public interface DemoService {
	Result<List<DemoEntity>> query(String name);

	Result delete(int id);

	Result update(DemoUpdateFormDTO formDTO);

	Result save(DemoSaveFormDTO formDTO);

	List<DemoExportExcel> queryAll();

	Result<List<DemoImportEntity>> importExcel(MultipartFile file);
}
