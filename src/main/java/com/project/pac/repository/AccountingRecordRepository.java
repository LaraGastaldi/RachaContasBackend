package com.project.pac.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.pac.model.AccountingRecordModel;

public interface AccountingRecordRepository extends JpaRepository<AccountingRecordModel, Long>{

	@Query("SELECT a FROM AccountingRecordModel a "
			+ "WHERE a.idUser = :userId "
			+ "AND a.emissionDate BETWEEN :initialDate AND :finalDate")
	public List<AccountingRecordModel> findByEmissionDate(Long userId, Calendar initialDate, Calendar finalDate);

	@Query("SELECT a FROM AccountingRecordModel a "
			+ "WHERE a.idUser = :userId "
			+ "AND a.paymentDate >= :paymentDate")
	public List<AccountingRecordModel> findByPaymentDate(Long userId, Calendar paymentDate);

	public List<AccountingRecordModel> findAllByIdUser(Long userId);
}
