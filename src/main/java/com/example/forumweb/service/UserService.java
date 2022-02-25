package com.example.forumweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.forumweb.model.User;
import com.example.forumweb.model.UserLogin;
import com.example.forumweb.repository.UserRepository;

@Service
public class UserService {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	public UserService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public String register(User user) {
		User us = new User();
		us.setUserName(user.getUserName());
		String userName = userRepo.findByUserName(user.getEmpId());
		us.setEmail(user.getEmail());
		us.setUserId(us.getUserId());
		us.setEmpId(user.getEmpId());
		us.setPassword(passwordEncoder.encode(user.getPassword()));
		if(userName == null) {
			userRepo.save(us);
			return "User added successfully";
		}
		else {
			return "User added Failed";
		}
	}

	public String login(UserLogin userLogin) {
		System.out.println(userLogin);
		String user = userRepo.findByUserName(userLogin.getUserName());
	
		String password = userLogin.getPassword();
		Boolean pass = passwordEncoder.matches(password, userRepo.findByUserPassword(user));
		if(user == null) {
			return "User Not Found";
		}
		if(!pass) {
			return "Password not matched";
		}
		return "Success";
	}

	public Long getUserId(String userName) {
		
		Long k = userRepo.findUserId(userName);
		System.out.println(k);
		return k;
	}

	public int getUsersCount() {
		
		return userRepo.getUsersCount();
	}

	public String getUserName(String user) {
		System.out.println(user);
		return userRepo.findByUserName(user);
	}

	public String getuserName(String userName) {
		return userRepo.getUserName(userName);
	}

	public String getEmpId(String empId) {
		return userRepo.getEmpId(empId);
	}
	
	

}
