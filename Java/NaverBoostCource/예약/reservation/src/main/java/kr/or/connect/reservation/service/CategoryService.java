package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;

public interface CategoryService {
	public static final Integer LIMIT = 5;
	public List<Category> getCategories(Integer start);
	public int getCount();
}