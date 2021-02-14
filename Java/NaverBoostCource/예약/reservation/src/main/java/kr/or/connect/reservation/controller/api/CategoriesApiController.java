package kr.or.connect.reservation.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
public class CategoriesApiController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start){
    	List<Category> list = categoryService.getCategories(start);
    	
    	int count = categoryService.getCount();
    	int pageCount = count / categoryService.LIMIT;
    	if(count % categoryService.LIMIT > 0)
    		pageCount++;
    	
    	List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * categoryService.LIMIT);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
    	return map;
    	
    }
}