package com.project.pac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project.pac.bean.CategoryBean;
import com.project.pac.factory.CategoryFactory;
import com.project.pac.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryBean> findAll(Long userId) {
		return new CategoryFactory().buildBeanList(categoryRepository.findAllByIdUser(userId));
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

	public CategoryBean update(CategoryBean category) throws Exception {
		CategoryBean savedBean = new CategoryBean();
		if(!categoryRepository.findById(category.getId()).isEmpty()) {
			savedBean = this.save(category);
		}else {
			throw new Exception("Category not found");
		}
		
		return savedBean;
	}
	
	public void deleteByIds(List<Long> categoryIds) throws Exception {
		categoryRepository.deleteAllById(categoryIds);
	}
}
