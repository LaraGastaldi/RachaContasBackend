package com.project.pac.bean;

import com.project.pac.enums.CategoryType;

import lombok.Data;

@Data
public class CategoryBean {
	
	private Long id;
	private Long idUser;
	private String description;
	private String name;
	private CategoryType type;
}
