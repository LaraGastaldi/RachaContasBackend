package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.SupplierBean;
import com.project.pac.model.SupplierModel;

public class SupplierFactory {

	public List<SupplierBean> buildBeanList(List<SupplierModel> listModel) {
		List<SupplierBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public SupplierBean buildBean(SupplierModel model) {
		SupplierBean bean =  new SupplierBean();

        bean.setId(model.getId());
        bean.setIdUser(model.getIdUser());
        bean.setCnpj(model.getCnpj());
        bean.setName(model.getName());
        bean.setPhone(model.getPhone());

        return bean;
    }

	public SupplierModel buildModel(SupplierBean bean) {
		SupplierModel model =  new SupplierModel();

        model.setId(bean.getId());
        model.setIdUser(bean.getIdUser());
        model.setCnpj(bean.getCnpj());
        model.setName(bean.getName());
        model.setPhone(bean.getPhone());
        
        return model;
	}
}
