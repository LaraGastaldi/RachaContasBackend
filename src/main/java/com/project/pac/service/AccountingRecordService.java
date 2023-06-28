package com.project.pac.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.AccountingRecordBean;
import com.project.pac.bean.ChartValuesBean;
import com.project.pac.bean.DashboardBean;
import com.project.pac.factory.AccountingRecordFactory;
import com.project.pac.model.AccountingRecordModel;
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
	
	public List<AccountingRecordBean> saveAll(List<AccountingRecordBean> categoryList) throws ParseException {
		List<AccountingRecordBean> savedBeans = new ArrayList<>();
		
		categoryList.forEach(bean -> {
			try {
				savedBeans.add(this.save(bean));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		
		return savedBeans;
	}
	
	public AccountingRecordBean save(AccountingRecordBean bean) throws ParseException {
		bean = new AccountingRecordFactory().buildBeanDates(bean);
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
	
	public List<AccountingRecordBean> findAllByType(Long userId, Boolean type) {
		List<AccountingRecordModel> result = accountingRecordRepository.findAllByIdUserAndType(userId, type);

		return new AccountingRecordFactory().buildBeanList(result);
	}
	
	public DashboardBean findDashboardInfo(Long userId, String date) throws ParseException {
		DashboardBean dashboard = new DashboardBean();
		LocalDate paymentDate = this.convertDate(date);
		Float finalBalance = 0.00f;
		
		List<AccountingRecordModel> result = accountingRecordRepository.findByPaymentDate(userId, paymentDate);
		
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
	
	public List<ChartValuesBean> findChartValues(Long userId, String year) throws ParseException{
		List<ChartValuesBean> chartList = new ArrayList<>();
		
		LocalDate startDate = LocalDate.of(Integer.parseInt(year), Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(Integer.parseInt(year), Month.DECEMBER, 31);

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
        	Float finalBalance = 0.00f;
            List<AccountingRecordModel> result = accountingRecordRepository.findByEmissionDate(userId, currentDate);
			
			for(AccountingRecordModel accountingRecord : result) {
				if(accountingRecord.getType()) {
					finalBalance += accountingRecord.getValue();
				}else {
					finalBalance -= accountingRecord.getValue();
				}
			}
			
			ChartValuesBean chartBean = new ChartValuesBean(this.formatDate(currentDate), finalBalance);
			chartList.add(chartBean);
			
			currentDate = currentDate.plusMonths(1);
        }

		return chartList;
	}
	
	private String formatDate(LocalDate date) {
		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String formattedDate = date.format(formatter);
		
		return formattedDate;
	}
	private LocalDate convertDate(String dateString) throws ParseException {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date =LocalDate.parse(dateString, dateFormat);
		
		return date;
	}
}
