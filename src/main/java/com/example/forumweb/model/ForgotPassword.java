package com.example.forumweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Builder.Default;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.scheduling.annotation.Scheduled;

@Entity
@Data
public class ForgotPassword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fpId;
	private String token;
	private String email;
	private String password;
	private String conformPassword;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date generatedAt;

}
