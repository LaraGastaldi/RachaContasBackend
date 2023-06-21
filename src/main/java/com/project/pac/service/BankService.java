package com.project.pac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.BankBean;
import com.project.pac.bean.CategoryBean;
import com.project.pac.factory.BankFactory;
import com.project.pac.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	public List<BankBean> findAll(Long userId){
		return new BankFactory().buildBeanList(bankRepository.findAllByIdUser(userId));
	}
	
	public BankBean findById(Long id){
		return new BankFactory().buildBean(bankRepository.findById(id).get());
	}
	
	public List<BankBean> saveAll(List<BankBean> categoryList){
		List<BankBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			savedBeans.add(this.save(bean));
		});
		
		return savedBeans;
	}
	
	public BankBean save(BankBean bean) {
		BankBean entity = new BankFactory().buildBean(bankRepository.save(new BankFactory().buildModel(bean))); 
		return entity;
	}

	public void deleteByIds(List<Long> bankIds) {
		bankRepository.deleteAllById(bankIds);
	}

	public BankBean update(BankBean bank) throws Exception {
		BankBean savedBean = new BankBean();
		if(!bankRepository.findById(bank.getId()).isEmpty()) {
			savedBean = this.save(bank);
		}else {
			throw new Exception("Bank not found");
		}
		
		return savedBean;
	}
}
