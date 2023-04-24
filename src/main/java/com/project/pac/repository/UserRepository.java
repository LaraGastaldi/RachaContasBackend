package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

}
