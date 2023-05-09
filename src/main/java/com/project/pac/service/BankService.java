package com.project.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.BankBean;
import com.project.pac.factory.BankFactory;
import com.project.pac.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	public List<BankBean> findAll(){
		return new BankFactory().buildBeanList(bankRepository.findAll());
	}
	
	public BankBean findById(Long id){
		return new BankFactory().buildBean(bankRepository.findById(id).get());
	}
}
