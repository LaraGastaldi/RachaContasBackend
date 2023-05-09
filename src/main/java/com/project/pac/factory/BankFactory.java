package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.BankBean;
import com.project.pac.model.BankModel;

public class BankFactory {
	
	public List<BankBean> buildBeanList(List<BankModel> listModel) {
		List<BankBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public BankBean buildBean(BankModel model) {
		BankBean bean =  new BankBean();

        bean.setId(model.getId());
        bean.setBankCode(model.getBankCode());
        bean.setBankName(model.getBankName());

        return bean;
    }
	
}
