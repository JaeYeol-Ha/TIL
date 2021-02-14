package org.edwith.webbe.calculator.service.impl;

import java.util.Date;
import java.util.List;

import org.edwith.webbe.calculator.dao.CategoryDao;
import org.edwith.webbe.calculator.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.edwith.webbe.calculator.dao.LogDao;
import org.edwith.webbe.calculator.dto.Categories;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired()
	LogDao logDao;

	@Override
	@Transactional
	public List<Categories> getCategories(Integer start) {
		List<Categories> list = categoryDao.selectAll(start, CategoriesService.LIMIT);
		return list;
	}

	@Override
	public int getCount() {
		return categoryDao.selectCount();
	}
	
	
}