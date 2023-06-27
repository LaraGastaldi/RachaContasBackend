package com.project.pac.factory;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

	public AccountingRecordBean buildBeanDates(AccountingRecordBean bean) throws ParseException {
		AccountingRecordBean newBean =  new AccountingRecordBean();

		newBean.setId(bean.getId());
		newBean.setIdSupplier(bean.getIdSupplier());
		newBean.setIdCategory(bean.getIdCategory());
		newBean.setIdBank(bean.getIdBank());
		newBean.setIdCliente(bean.getIdCliente());
		newBean.setIdUser(bean.getIdUser());
		newBean.setEmissionDate(this.convertDate(bean.getEmissionDateString()));
		newBean.setPaymentDate(this.convertDate(bean.getPaymentDateString()));
		newBean.setMaturityDate(this.convertDate(bean.getMaturityDateString()));
		newBean.setObservation(bean.getObservation());
		newBean.setValue(bean.getValue());
		newBean.setType(bean.getType());

        return newBean;
	}
	
	private LocalDate convertDate(String dateString) throws ParseException {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date =LocalDate.parse(dateString, dateFormat);
		
		return date;
	}
}
