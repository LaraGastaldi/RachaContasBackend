package com.project.pac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bean.ClientBean;
import com.project.pac.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping(path="/findAll")
	public List<ClientBean> findAll(@RequestParam("userId") Long userId){
		return clientService.findAll(userId);
	}
	
	@PostMapping
	public List<ClientBean> saveAll(@RequestBody List<ClientBean> clientList){
		return clientService.saveAll(clientList);
	}
	
	@PutMapping
	public ClientBean update(@RequestBody ClientBean client) throws Exception {
		return clientService.update(client);
	}
	
	@DeleteMapping
	public void delete(@RequestParam("ids") List<Long> clientIds) throws Exception {
		clientService.deleteByIds(clientIds);
	}

}
