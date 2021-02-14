package kr.co.connect.reservation2.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import kr.co.connect.reservation2.dto.Category;
import kr.co.connect.reservation2.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoriesApiController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "덧셈 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
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