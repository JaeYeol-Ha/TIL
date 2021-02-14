package kr.or.connect.reservation2.service.impl;

import java.util.Date;
import java.util.List;

import kr.or.connect.reservation2.dao.CategoryDao;
import kr.or.connect.reservation2.dao.LogDao;
import kr.or.connect.reservation2.dto.Category;
import kr.or.connect.reservation2.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired()
	LogDao logDao;

	@Override
	@Transactional
	public List<Category> getCategories(Integer start) {
		List<Category> list = categoryDao.selectAll(start, CategoryService.LIMIT);
		return list;
	}

	@Override
	public int getCount() {
		return categoryDao.selectCount();
	}
	
	
}