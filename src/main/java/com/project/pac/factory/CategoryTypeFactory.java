package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.CategoryTypeBean;
import com.project.pac.model.CategoryTypeModel;

public class CategoryTypeFactory {

	public List<CategoryTypeBean> buildBeanList(List<CategoryTypeModel> listModel) {
		List<CategoryTypeBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public CategoryTypeBean buildBean(CategoryTypeModel model) {
		CategoryTypeBean bean =  new CategoryTypeBean();

        bean.setId(model.getId());
        bean.setDescription(model.getDescription());

        return bean;
    }
}
