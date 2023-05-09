package com.project.pac.model;

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
@Table(name="bank", schema = "public")
public class BankModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bank")
	private Long id;
	
	@Column(name="bank_code")
	private String bankCode;
	
	@Column(name="bank_name")
	private String bankName;
}
