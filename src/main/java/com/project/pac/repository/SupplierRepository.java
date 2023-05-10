package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.SupplierModel;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {

}
