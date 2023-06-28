package com.project.pac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.ClientBean;
import com.project.pac.bean.SupplierBean;
import com.project.pac.factory.SupplierFactory;
import com.project.pac.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public List<SupplierBean> findAll(){
		return new SupplierFactory().buildBeanList(supplierRepository.findAll());
	}
	
	public SupplierBean findById(Long id){
		return new SupplierFactory().buildBean(supplierRepository.findById(id).get());
	}
	
	public List<SupplierBean> saveAll(List<SupplierBean> categoryList){
		List<SupplierBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			savedBeans.add(this.save(bean));
		});
		
		return savedBeans;
	}
	
	public SupplierBean save(SupplierBean bean) {
		SupplierBean entity = new SupplierFactory().buildBean(supplierRepository.save(new SupplierFactory().buildModel(bean))); 
		return entity;
	}

	public SupplierBean update(SupplierBean supplier) throws Exception {
		SupplierBean savedBean = new SupplierBean();
		if(!supplierRepository.findById(supplier.getId()).isEmpty()) {
			savedBean = this.save(supplier);
		}else {
			throw new Exception("Supplier not found");
		}
		
		return savedBean;
	}

	public void deleteByIds(List<Long> clientIds) {
		supplierRepository.deleteAllById(clientIds);
	}
}
