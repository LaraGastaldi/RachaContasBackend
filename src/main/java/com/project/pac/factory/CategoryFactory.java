package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.CategoryBean;
import com.project.pac.model.CategoryModel;

public class CategoryFactory{

	public List<CategoryBean> buildBeanList(List<CategoryModel> listModel) {
		List<CategoryBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public CategoryBean buildBean(CategoryModel model) {
		CategoryBean bean =  new CategoryBean();
		
		bean.setId(model.getId());
		bean.setName(model.getName());
		bean.setDescription(model.getDescription());
		
		return bean;
	}

	public CategoryModel buildModel(CategoryBean bean) {
		CategoryModel model =  new CategoryModel();
		
		model.setId(bean.getId());
		model.setName(bean.getName());
		model.setDescription(bean.getDescription());
		
		return model;
	}
}
