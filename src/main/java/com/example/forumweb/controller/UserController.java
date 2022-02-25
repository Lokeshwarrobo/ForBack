package com.example.forumweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumweb.model.User;
import com.example.forumweb.model.UserLogin;
import com.example.forumweb.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	@CrossOrigin(origins = "*")
	public String register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "*")
	public String login(@RequestBody UserLogin userLogin) {
		return userService.login(userLogin);
	}
	
	@PostMapping("/{userName}")
	@CrossOrigin(origins = "*")
	public Long getUserId(@PathVariable("userName") String userName) {
		
		return userService.getUserId(userName);
	}
	
	@GetMapping("/count")
	@CrossOrigin(origins = "*")
	public int getUsersCount() {
		return userService.getUsersCount();
	}
	
	@GetMapping("/name/{userName}")
	@CrossOrigin(origins = "*")
	public String getUserName(@PathVariable("userName") String userName) {
		return userService.getuserName(userName);
	}
	
	@GetMapping("/us/{empId}")
	@CrossOrigin(origins = "*")
	public String getEmpId(@PathVariable("empId") String empId) {
		return userService.getEmpId(empId);
	}
	
//	@PostMapping("/user")
//	public String getUserName(@RequestBody User user) {
//		return userService.getUserName(user.);
//	}

}
