package com.example.forumweb.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data

public class Question {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String question;
	private String questionDesc;
	private Long userId;
	private String questionDate;
	private String userName;
	private Long categoryId;
	private int views;
	private int likes;
	private int replies;



}
