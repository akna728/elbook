package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserList implements Serializable {
	
	private int user_id;
	
	@NotBlank
	private String user_name;
	
	@NotBlank
	private String mail;
	
	@NotBlank
	@Size(min = 12, max = 200)
	private String pass;
	
	private Date create_time;
	
	private boolean delete_flg;
	
	private Authority authority;
	
	public enum Authority{
		ADMIN, USER,
	}

}
