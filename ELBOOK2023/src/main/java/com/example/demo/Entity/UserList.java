package com.example.demo.Entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.validator.constraints.Length;

import com.example.demo.Repository.UserRepository;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserList implements Serializable {
	
	private int user_id;
	
	@NotBlank
	private String user_name;
	
	@NotBlank
	private String mail;
	
	@NotBlank
	@Length(min=8, max=32)
	@jakarta.validation.constraints.Pattern(regexp="[a-zA-Z0-9]*")
	private String pass;
	
	private Date create_time;
	
	private boolean delete_flg;
	
	private Authority authority;
	
	public enum Authority{
		ADMIN, USER,
	}
	
	public UserList(UserRepository userRepository) {
		this.user_id = userRepository.getUser_Id();
	}

}
