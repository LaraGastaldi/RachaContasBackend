package com.project.pac.bean;

import java.time.LocalDate;

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
	private LocalDate emissionDate;
	private String emissionDateString;
	private LocalDate paymentDate;
	private String paymentDateString;
	private LocalDate maturityDate;
	private String maturityDateString;
	private String observation;
	private Float value;
	private Boolean type;
}
