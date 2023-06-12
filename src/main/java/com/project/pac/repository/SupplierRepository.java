package com.project.pac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.SupplierModel;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {

	List<SupplierModel> findAllByIdUser(Long userId);

}
