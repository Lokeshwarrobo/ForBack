package com.example.forumweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class QuestionSearch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long searchId;
	private String question;
}
