package org.edwith.webbe.calculator.service;

import java.util.List;

import org.edwith.webbe.calculator.dto.Categories;

public interface CategoriesService {
	public static final Integer LIMIT = 5;
	public List<Categories> getCategories(Integer start);
	public int getCount();
}