package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.model.User;
import com.project.pac.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserContoller {

	@Autowired
	UserService userService;
	
	@GetMapping(path="/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping(path="/findById/{id}")
	public User findById(@PathVariable("id") Long id){
		return userService.findById(id);
	}
}
