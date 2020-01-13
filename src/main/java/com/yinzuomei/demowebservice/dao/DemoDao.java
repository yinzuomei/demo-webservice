package com.yinzuomei.demowebservice.dao;

import com.yinzuomei.demowebservice.dto.DemoExportExcel;
import com.yinzuomei.demowebservice.dto.DemoSaveFormDTO;
import com.yinzuomei.demowebservice.dto.DemoUpdateFormDTO;
import com.yinzuomei.demowebservice.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: yinzuomei
 * @Date: 2020/1/13 13:27
 * @Description:
 */
@Mapper
public interface DemoDao {
	List<DemoEntity> query(String name);

	int delete(int id);

	int update(DemoUpdateFormDTO formDTO);

	int save(DemoSaveFormDTO formDTO);

	List<DemoExportExcel> queryAll();
}
