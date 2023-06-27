package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.UserBean;
import com.project.pac.model.UserModel;

public class UserFactory {

	public List<UserBean> buildBeanList(List<UserModel> listModel) {
		List<UserBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public UserBean buildBean(UserModel model) {
        UserBean bean =  new UserBean();

        bean.setId(model.getId());
        bean.setUserName(model.getUserName());
        bean.setPassword(model.getPassword());
        bean.setCnpj(model.getCnpj());

        return bean;
    }

	public UserModel buildModel(UserBean bean) {
		UserModel model =  new UserModel();

        model.setId(bean.getId());
        model.setUserName(bean.getUserName());
        model.setPassword(bean.getPassword());
        model.setCnpj(bean.getCnpj());

        return model;
	}

}
