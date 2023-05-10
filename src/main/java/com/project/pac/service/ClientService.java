package com.project.pac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.ClientBean;
import com.project.pac.factory.ClientFactory;
import com.project.pac.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public List<ClientBean> findAll() {
		return new ClientFactory().buildBeanList(clientRepository.findAll());
	}
	
	public List<ClientBean> saveAll(List<ClientBean> categoryList){
		List<ClientBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			savedBeans.add(this.save(bean));
		});
		
		return savedBeans;
	}
	
	public ClientBean save(ClientBean bean) {
		ClientBean entity = new ClientFactory().buildBean(clientRepository.save(new ClientFactory().buildModel(bean))); 
		return entity;
	}
}
