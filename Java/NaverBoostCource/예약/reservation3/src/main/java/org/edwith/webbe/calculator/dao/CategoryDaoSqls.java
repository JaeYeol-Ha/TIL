package org.edwith.webbe.calculator.dao;

public class CategoryDaoSqls {
	public static final String SELECT_PAGING = "SELECT id, item FROM categories ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}