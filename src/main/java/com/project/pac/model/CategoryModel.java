package com.project.pac.model;

import com.project.pac.enums.CategoryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="category", schema = "public")
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_category")
	private Long id;
	
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private CategoryType type;
}
