package com.example.demo.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	int getUser_Id();

	Object findByUser_Id(User user);

}
