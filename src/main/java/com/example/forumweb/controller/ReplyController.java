package com.example.forumweb.controller;

import com.example.forumweb.model.Reply;
import com.example.forumweb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@CrossOrigin(origins = "*")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/rep")
    @CrossOrigin(origins = "*")
    public String giveReply(@RequestBody Reply reply) {
        return replyService.giveReply(reply);

    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Reply> getReply() {
        return replyService.getReply();
    }
    
    @PutMapping("/update/{replyId}")
    @CrossOrigin(origins = "*")
    public String updateReply(@PathVariable("replyId") Long replyId, @RequestBody Reply reply) {
    	return replyService.updateReply(replyId, reply);
    }
    
    @GetMapping("/all/{answerId}")
    @CrossOrigin(origins = "*")
    public List<Reply> getReplyByAnswerId(@PathVariable("answerId") Long answerId) {
    	return replyService.getReplyByAnswerId(answerId);
    }
    
    
    
    
}
