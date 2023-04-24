package com.project.pac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
