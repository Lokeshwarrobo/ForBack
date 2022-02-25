package com.example.forumweb.service;

import com.example.forumweb.model.Reply;
import com.example.forumweb.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public String giveReply(Reply reply) {
        Reply rep = new Reply();
        Long repId = reply.getRepId();
        Long re = 0l;
        rep.setReply(reply.getReply());
        rep.setReplyId(reply.getReplyId());
        rep.setAnswerId(reply.getAnswerId());
        rep.setUserId(reply.getUserId());
        rep.setQuestionId(reply.getQuestionId());
        if(repId == replyRepository.findRepId(reply.getReplyId())) {
            rep.setRepId(repId);
        }
        else  {
            rep.setRepId(re);
        }
        replyRepository.save(rep);
        return "added";
    }

    public List<Reply> getReply() {
        return  replyRepository.findAll();
    }

	public String updateReply(Long replyId, Reply reply) {
		Reply rep = replyRepository.findById(replyId).get();
		rep.setReply(reply.getReply());
		rep.setAnswerId(reply.getAnswerId());
		replyRepository.save(rep);
		return "updated successfully";
	}

	public List<Reply> getReplyByAnswerId(Long answerId) {
		
		return replyRepository.findReplyByAnswerId(answerId);
	}

	
}
