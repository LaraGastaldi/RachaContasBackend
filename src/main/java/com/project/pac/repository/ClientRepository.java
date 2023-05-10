package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{

}
