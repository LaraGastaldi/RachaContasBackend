package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.service.AccountingRecordService;

@RestController
@RequestMapping(value="/accounting_record")
public class AccountingRecordController {

	@Autowired
	AccountingRecordService accountingRecordService;
	
	@GetMapping(path="/findAll")
	public List<AccountingRecordBean> findAll(){
		return accountingRecordService.findAll();
	}
	
	@GetMapping(path="/find")
	public AccountingRecordBean findById(@RequestParam("id") Long id){
		return accountingRecordService.findById(id);
	}
	
	@PostMapping
	public List<AccountingRecordBean> saveAll(@RequestBody List<AccountingRecordBean> accountingRecordList){
		return accountingRecordService.saveAll(accountingRecordList);
	}
}
