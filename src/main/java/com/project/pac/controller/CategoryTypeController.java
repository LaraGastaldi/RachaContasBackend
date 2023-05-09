package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.CategoryTypeBean;
import com.project.pac.service.CategoryTypeService;

@RestController
@RequestMapping(value="/category_type")
public class CategoryTypeController {
	@Autowired
	CategoryTypeService categoryTypeService;
	
	@GetMapping(path="/findAll")
	public List<CategoryTypeBean> findAll(){
		return categoryTypeService.findAll();
	}
	
	@GetMapping(path="/find")
	public CategoryTypeBean findById(@RequestParam("id") Long id){
		return categoryTypeService.findById(id);
	}
}
