package kr.or.connect.reservation2.service;

import java.util.List;

import kr.or.connect.reservation2.dto.Category;

public interface CategoryService {
	public static final Integer LIMIT = 5;
	public List<Category> getCategories(Integer start);
	public int getCount();
}