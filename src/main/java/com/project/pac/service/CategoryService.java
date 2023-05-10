package com.project.pac.service;

import java.util.ArrayList;
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
	
	public List<CategoryBean> saveAll(List<CategoryBean> categoryList){
		List<CategoryBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			savedBeans.add(this.save(bean));
		});
		
		return savedBeans;
	}
	
	public CategoryBean save(CategoryBean bean) {
		CategoryBean entity = new CategoryFactory().buildBean(categoryRepository.save(new CategoryFactory().buildModel(bean))); 
		return entity;
	}
}
