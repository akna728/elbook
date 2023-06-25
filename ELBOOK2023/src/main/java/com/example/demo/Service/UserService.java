package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public List<UserList> findUser(){
		return userMapper.findUser();
	}
	
	public UserList targetUser(int user_id){
		return userMapper.targetUser(user_id);
	}
	
	public UserList emailFindUser(String mail) {
		return userMapper.emailFindUser(mail);
	}
	
	public void createUser(UserList userList) {
		userMapper.createUser(userList);
	}
	
	public void editUser(UserList useList) {
		userMapper.editUser(useList);
	}
	
	public void deleteUser(int user_id) {
		userMapper.deleteUser(user_id);
	}

	public void emailDeleteUser(String email) {
		userMapper.emailDeleteUser(email);
	}

}
