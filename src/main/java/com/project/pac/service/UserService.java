package com.project.pac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bean.UserBean;
import com.project.pac.factory.UserFactory;
import com.project.pac.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserBean> findAll(){
		return new UserFactory().buildBeanList(userRepository.findAll());
	}
	
	public UserBean findById(Long id){
		return new UserFactory().buildBean(userRepository.findById(id).get());
	}
}
