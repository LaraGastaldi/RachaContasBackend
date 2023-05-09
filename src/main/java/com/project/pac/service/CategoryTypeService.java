package com.project.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.CategoryTypeBean;
import com.project.pac.factory.CategoryTypeFactory;
import com.project.pac.repository.CategoryTypeRepository;

@Service
public class CategoryTypeService {

	@Autowired
	CategoryTypeRepository categoryTypeRepository;
	
	public List<CategoryTypeBean> findAll(){
		return new CategoryTypeFactory().buildBeanList(categoryTypeRepository.findAll());
	}
	
	public CategoryTypeBean findById(Long id){
		return new CategoryTypeFactory().buildBean(categoryTypeRepository.findById(id).get());
	}
}
