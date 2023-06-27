package com.project.pac.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="accounting_record", schema = "public")
public class AccountingRecordModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_record")
	private Long id;
	
	@Column(name="id_supplier")
	private Long idSupplier;
	
	@Column(name="id_category")
	private Long idCategory;
	
	@Column(name="id_bank")
	private Long idBank;
	
	@Column(name="id_cliente")
	private Long idCliente;
	
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="emission_date")
	private LocalDate emissionDate;
	
	@Column(name="payment_date")
	private LocalDate paymentDate;
	
	@Column(name="maturity_date")
	private LocalDate maturityDate;
	
	@Column(name="observation")
	private String observation;
	
	@Column(name="value")
	private Float value;
	
	@Column(name="type")
	private Boolean type;
}
