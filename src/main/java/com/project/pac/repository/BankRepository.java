package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.BankModel;

public interface BankRepository extends JpaRepository<BankModel, Long>{

}
