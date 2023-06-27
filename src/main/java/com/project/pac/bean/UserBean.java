package com.project.pac.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserBean {

	private Long id;
	private String userName;
	private String password;
	private String cnpj;
	private Boolean auth;
		
}
