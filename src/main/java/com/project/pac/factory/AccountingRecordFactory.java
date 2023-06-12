package com.project.pac.factory;

import java.util.ArrayList;
import java.util.List;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.model.AccountingRecordModel;

public class AccountingRecordFactory {

	public List<AccountingRecordBean> buildBeanList(List<AccountingRecordModel> listModel) {
		List<AccountingRecordBean> listBean = new ArrayList<>();
		
		listModel.forEach(model -> {
			listBean.add(this.buildBean(model));
		});
		
		return listBean;
	}
	
	public AccountingRecordBean buildBean(AccountingRecordModel model) {
		AccountingRecordBean bean =  new AccountingRecordBean();

        bean.setId(model.getId());
        bean.setIdSupplier(model.getIdSupplier());
        bean.setIdCategory(model.getIdCategory());
        bean.setIdBank(model.getIdBank());
        bean.setIdCliente(model.getIdCliente());
        bean.setIdUser(model.getIdUser());
        bean.setEmissionDate(model.getEmissionDate());
        bean.setPaymentDate(model.getPaymentDate());
        bean.setMaturityDate(model.getMaturityDate());
        bean.setObservation(model.getObservation());
        bean.setValue(model.getValue());
        bean.setType(model.getType());

        return bean;
    }

	public AccountingRecordModel buildModel(AccountingRecordBean bean) {
		AccountingRecordModel model =  new AccountingRecordModel();

        model.setId(bean.getId());
        model.setIdSupplier(bean.getIdSupplier());
        model.setIdCategory(bean.getIdCategory());
        model.setIdBank(bean.getIdBank());
        model.setIdCliente(bean.getIdCliente());
        model.setIdUser(bean.getIdUser());
        model.setEmissionDate(bean.getEmissionDate());
        model.setPaymentDate(bean.getPaymentDate());
        model.setMaturityDate(bean.getMaturityDate());
        model.setObservation(bean.getObservation());
        model.setValue(bean.getValue());
        model.setType(bean.getType());
        
        return model;
	}
}
