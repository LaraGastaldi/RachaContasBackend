package com.project.pac.bean;

import java.util.Calendar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountingRecordBean {
	
	private Long id;
	private Long idSupplier;
	private Long idCategory;
	private Long idBank;
	private Long idCliente;
	private Long idUser;
	private Calendar emissionDate;
	private Calendar paymentDate;
	private Calendar maturityDate;
	private String observation;
	private Float value;
	private boolean type;
}
