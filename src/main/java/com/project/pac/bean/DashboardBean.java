package com.project.pac.bean;

import lombok.Data;

@Data
public class DashboardBean {

	private Float receivedValue = 0.0F;
	private Float paidValue = 0.0F;
	private Float finalBalance = 0.0F;
	private Long userId;
	
}
