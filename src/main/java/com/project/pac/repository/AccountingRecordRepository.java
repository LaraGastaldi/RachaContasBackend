package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.AccountingRecordModel;

public interface AccountingRecordRepository extends JpaRepository<AccountingRecordModel, Long>{

}
