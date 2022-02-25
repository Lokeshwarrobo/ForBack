package com.example.forumweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumweb.model.Category;
import com.example.forumweb.service.CategoryService;

@RestController
@RequestMapping("/ca")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/searchcat/{categoryName}")
	@CrossOrigin(origins = "*")
	public List<Category> searchCategory(@PathVariable("categoryName") String categoryName) {
		return categoryService.searchCategory(categoryName);
	}

}
