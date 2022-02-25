package com.example.forumweb.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String answer;
	private Long questionId;
	private String answeredDate;
	private Long userId;
	private String userName;
//	private boolean bestAnswer;


}
