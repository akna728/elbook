package com.example.demo.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

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
	
	private Collection<? extends GrantedAuthority> authority;
	
	public enum Authority{
		ADMIN, USER,
	}

}
