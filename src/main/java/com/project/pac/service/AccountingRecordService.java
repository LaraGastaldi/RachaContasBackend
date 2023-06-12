package com.project.pac.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.bean.DashboardBean;
import com.project.pac.factory.AccountingRecordFactory;
import com.project.pac.model.AccountingRecordModel;
import com.project.pac.repository.AccountingRecordRepository;

@Service
public class AccountingRecordService {
	
	@Autowired
	AccountingRecordRepository accountingRecordRepository;
	
	public List<AccountingRecordBean> findAll(Long userId){
		return new AccountingRecordFactory().buildBeanList(accountingRecordRepository.findAllByIdUser(userId));
	}
	
	public AccountingRecordBean findById(Long id){
		return new AccountingRecordFactory().buildBean(accountingRecordRepository.findById(id).get());
	}
	
	public List<AccountingRecordBean> saveAll(List<AccountingRecordBean> categoryList){
		List<AccountingRecordBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			savedBeans.add(this.save(bean));
		});
		
		return savedBeans;
	}
	
	public AccountingRecordBean save(AccountingRecordBean bean) {
		AccountingRecordBean entity = new AccountingRecordFactory().buildBean(accountingRecordRepository.save(new AccountingRecordFactory().buildModel(bean))); 
		return entity;
	}

	public AccountingRecordBean update(AccountingRecordBean accountingBean) throws Exception {
		AccountingRecordBean savedBean = new AccountingRecordBean();
		if(!accountingRecordRepository.findById(accountingBean.getId()).isEmpty()) {
			savedBean = this.save(accountingBean);
		}else {
			throw new Exception("Accouting not found");
		}
		
		return savedBean;
	}
	
	public void deleteByIds(List<Long> clientIds) throws Exception {
		accountingRecordRepository.deleteAllById(clientIds);
	}

	public List<AccountingRecordBean> findByEmissionDateFilter(Long userId, Calendar initialDate, Calendar finalDate) {
		List<AccountingRecordModel> result = accountingRecordRepository.findByEmissionDate(userId, initialDate, finalDate);

		return new AccountingRecordFactory().buildBeanList(result);
	}
	
	public DashboardBean findDashboardInfo(Long userId, Calendar paymentDate) {
		DashboardBean dashboard = new DashboardBean();
		List<AccountingRecordModel> result = accountingRecordRepository.findByPaymentDate(userId, paymentDate);
		Float finalBalance = 0.00f;
		
		for(AccountingRecordModel accountingRecord : result) {
			if(accountingRecord.getType()) {
				finalBalance += accountingRecord.getValue();
				dashboard.setReceivedValue(dashboard.getReceivedValue() + accountingRecord.getValue());
			}else {
				finalBalance -= accountingRecord.getValue();
				dashboard.setPaidValue(dashboard.getPaidValue() + accountingRecord.getValue());
			}
		}
		
		dashboard.setFinalBalance(finalBalance);
		
		return dashboard;
	}
}
