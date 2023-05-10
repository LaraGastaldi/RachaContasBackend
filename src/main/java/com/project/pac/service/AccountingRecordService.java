package com.project.pac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.factory.AccountingRecordFactory;
import com.project.pac.repository.AccountingRecordRepository;

@Service
public class AccountingRecordService {
	
	@Autowired
	AccountingRecordRepository accountingRecordRepository;
	
	public List<AccountingRecordBean> findAll(){
		return new AccountingRecordFactory().buildBeanList(accountingRecordRepository.findAll());
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
}
