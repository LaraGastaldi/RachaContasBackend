package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.CategoryBean;
import com.project.pac.service.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path="/findAll")
	public List<CategoryBean> findAll(){
		return categoryService.findAll();
	}
	
	@PostMapping
	public List<CategoryBean> saveAll(@RequestBody List<CategoryBean> categoryList){
		return categoryService.saveAll(categoryList);
	}
}
