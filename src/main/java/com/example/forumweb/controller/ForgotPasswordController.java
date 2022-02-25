package com.example.forumweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumweb.model.ForgotPassword;
import com.example.forumweb.model.User;
import com.example.forumweb.service.ForgotPasswordService;

@RestController
@RequestMapping("/forgot")
@CrossOrigin(origins = "*")
public class ForgotPasswordController {
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@PostMapping("/change")
	@CrossOrigin(origins = "*")
	public String changePassword(@RequestBody ForgotPassword fp) {
		return forgotPasswordService.changePassword(fp);
	}
	
	@GetMapping("/all")
	@CrossOrigin(origins = "*")
	public List<ForgotPassword> getAll() {
		return forgotPasswordService.getAll();
	}
	
	@PostMapping("/gentkn")
	@CrossOrigin(origins = "*")
	public String generateToken(@RequestBody User user) {
		return forgotPasswordService.generateToken(user.getEmail());
	}

}
