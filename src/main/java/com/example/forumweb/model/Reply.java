package com.example.forumweb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyId;
    private String reply;
    private Long answerId;
    private Long userId;
    private Long questionId;
    private Long repId;

}
