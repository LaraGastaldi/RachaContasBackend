package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.ClientBean;
import com.project.pac.model.ClientModel;

public class ClientFactory {

	public List<ClientBean> buildBeanList(List<ClientModel> listModel) {
		List<ClientBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public ClientBean buildBean(ClientModel model) {
		ClientBean bean = new ClientBean();

        bean.setId(model.getId());
        bean.setIdUser(model.getIdUser());
        bean.setName(model.getName());
        bean.setCnpj(model.getCnpj());
        bean.setPhone(model.getPhone());

        return bean;
    }

	public ClientModel buildModel(ClientBean bean) {
		ClientModel model = new ClientModel();

        model.setId(bean.getId());
        model.setIdUser(bean.getIdUser());
        model.setName(bean.getName());
        model.setCnpj(bean.getCnpj());
        model.setPhone(bean.getPhone());

        return model;
	}

}
