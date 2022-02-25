package com.example.forumweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumweb.model.Category;
import com.example.forumweb.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public List<Category> searchCategory(String categoryName) {
			
			return categoryRepo.searchCategory(categoryName);
		}
	

}
