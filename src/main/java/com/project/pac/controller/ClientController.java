package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.ClientBean;
import com.project.pac.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping(path="/findAll")
	public List<ClientBean> findAll(){
		return clientService.findAll();
	}
	
	@PostMapping
	public List<ClientBean> saveAll(@RequestBody List<ClientBean> clientList){
		return clientService.saveAll(clientList);
	}
}
