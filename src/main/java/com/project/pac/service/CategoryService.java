package com.project.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.CategoryBean;
import com.project.pac.factory.CategoryFactory;
import com.project.pac.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryBean> findAll() {
		return new CategoryFactory().buildBeanList(categoryRepository.findAll());
	}
}
