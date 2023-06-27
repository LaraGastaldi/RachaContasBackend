package com.project.pac.repository;

import java.time.LocalDate;
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
	public List<AccountingRecordModel> findByPaymentDate(Long userId, LocalDate paymentDate);

	public List<AccountingRecordModel> findAllByIdUser(Long userId);

	@Query("SELECT a FROM AccountingRecordModel a "
			+ "WHERE a.idUser = :userId "
			+ "AND EXTRACT(MONTH FROM a.emissionDate) = EXTRACT(MONTH FROM CAST(:emissionDate AS java.sql.Date))")
	public List<AccountingRecordModel> findByEmissionDate(Long userId, LocalDate emissionDate);
}
