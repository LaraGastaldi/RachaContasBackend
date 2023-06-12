package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.SupplierBean;
import com.project.pac.service.SupplierService;

@RestController
@RequestMapping(value="/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@GetMapping(path="/findAll")
	public List<SupplierBean> findAll(@RequestParam("userId") Long userId){
		return supplierService.findAll(userId);
	}
	
	@GetMapping(path="/find")
	public SupplierBean findById(@RequestParam("id") Long id){
		return supplierService.findById(id);
	}
	
	@PostMapping
	public List<SupplierBean> saveAll(@RequestBody List<SupplierBean> accountingRecordList){
		return supplierService.saveAll(accountingRecordList);
	}
}
