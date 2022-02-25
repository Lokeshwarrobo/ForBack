package com.example.forumweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumweb.model.Answer;
import com.example.forumweb.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
	public Answer answerQuestion( Answer answer) {
//		Answer ans = new Answer();
//		ans.setAnsweredDate(answer.getAnsweredDate());
//		ans.setAnswerId(answer.getAnswerId());
//		ans.setAnswer(answer.getAnswer());
//		ans.setQuestionId(answer.getQuestionId() ) ;
//		ans.setUserId(answer.getUserId()); 	
//		ans.setUserName(answer.getUserName());	
		return answerRepo.save(answer);
	}

	public List<Answer> getAllAnswers() {
		return answerRepo.findAll();
	}

	public List<Answer> getAnswerByQuestionId(Long questionId) {
		
		return answerRepo.getAnswerByQuestionId(questionId);
	}

	public Answer modifyAnswer(Long answerId, Answer answer) {
		Answer ans = answerRepo.findById(answerId).get();
		ans.setAnswer(answer.getAnswer());
		return answerRepo.save(ans);
	}

	public String deleteMyAnswer(Long answerId) {
		answerRepo.deleteById(answerId);
		return "Deleted your answer Successfully";
	}

	public String deleteAllMyAnswers() {
		answerRepo.deleteAll();
		return "Deleted all answers successfully";
	}
	
	public int getNoOfAnswers(Long questionId) {
		return answerRepo.getAsnwersCount(questionId);
	}

	public List<Answer> getAnswersByUserId(Long userId) {
		return answerRepo.getAnswersByUserId(userId) ;
	}

	public int getTotalAnswers() {
		return answerRepo.getTotalAnswers();
	}


    public List<Answer> sortByRecent(Long questionId) {
		return answerRepo.sortByRecent(questionId);
    }

//    public String modifyBest(Long answerId, Boolean bestAnswer) {
//		Answer ans = answerRepo.findById(answerId).get();
//		ans.setBestAnswer(bestAnswer);
//		answerRepo.save(ans);
//		return "Updated";
//    }
}
