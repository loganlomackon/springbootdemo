package com.rbc.springbootdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbc.springbootdemo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	//select * from sys_user where user_name = X and password = Y;
	User findByUserNameAndPassword(String userName, String password);
	
}
