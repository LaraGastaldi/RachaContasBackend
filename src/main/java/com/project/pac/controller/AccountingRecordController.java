package com.project.pac.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.bean.ChartValuesBean;
import com.project.pac.bean.DashboardBean;
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
	public List<AccountingRecordBean> saveAll(@RequestBody List<AccountingRecordBean> accountingRecordList) throws ParseException{
		return accountingRecordService.saveAll(accountingRecordList);
	}
	
	@PutMapping
	public AccountingRecordBean update(@RequestBody AccountingRecordBean accountingBean) throws Exception {
		return accountingRecordService.update(accountingBean);
	}
	
	@DeleteMapping
	public void deleteByIdsIn(@RequestParam("ids") List<Long> accountingIds) throws Exception {
		accountingRecordService.deleteByIds(accountingIds);
	}
	
	@GetMapping
	public List<AccountingRecordBean> findByEmissionDate(@RequestParam Long userId, @RequestParam Calendar initialDate, @RequestParam Calendar finalDate){
		return accountingRecordService.findByEmissionDateFilter(userId, initialDate, finalDate);
	}
	
	@GetMapping(path="/findByType")
	public List<AccountingRecordBean> findByType(@RequestParam Long userId, @RequestParam Boolean type){
		return accountingRecordService.findAllByType(userId, type);
	}
	
	@GetMapping("/findDashboard")
	public DashboardBean findDashboardInfo(@RequestParam Long userId, @RequestParam String paymentDate) throws ParseException {
		return accountingRecordService.findDashboardInfo(userId, paymentDate);
	}
	
	@GetMapping("/findChartValues")
	public List<ChartValuesBean> findChartValues(@RequestParam Long userId, @RequestParam String year) throws ParseException {
		return accountingRecordService.findChartValues(userId, year);
	}
}
