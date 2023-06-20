package com.project.pac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{
	
	List<CategoryModel> findAllByIdUser(Long userId);

}
