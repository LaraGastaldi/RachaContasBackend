package com.project.pac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.BankModel;

public interface BankRepository extends JpaRepository<BankModel, Long>{

	List<BankModel> findAllByIdUser(Long userId);

}
