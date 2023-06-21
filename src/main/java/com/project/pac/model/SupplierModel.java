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
@Table(name="supplier", schema = "public")
public class SupplierModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_supplier")
	private Long id;
	
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
}
