package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.BankBean;
import com.project.pac.bean.CategoryBean;
import com.project.pac.service.BankService;

@RestController
@RequestMapping(value="/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@GetMapping(path="/findAll")
	public List<BankBean> findAll(){
		return bankService.findAll();
	}
	
	@GetMapping(path="/find")
	public BankBean findById(@RequestParam("id") Long id){
		return bankService.findById(id);
	}
	
	@PostMapping
	public List<BankBean> saveAll(@RequestBody List<BankBean> bankList){
		return bankService.saveAll(bankList);
	}
}
