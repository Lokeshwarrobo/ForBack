package com.example.forumweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumweb.model.Answer;
import com.example.forumweb.service.AnswerService;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "*")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	

	// api for answering a question
	@PostMapping("/answer")
	@CrossOrigin(origins = "*")
	public Answer answerQuestion(@RequestBody Answer answer) {
		return answerService.answerQuestion(answer);
	}
	
	
	// api for getting all answers
	@GetMapping("/all")
	@CrossOrigin(origins = "*")
	public List<Answer> getAllAnswers() {
		return answerService.getAllAnswers();
	}
	
	// api for getting answer by QuestionId
	@GetMapping("/all/{questionId}")
	@CrossOrigin(origins = "*")
	public List<Answer> getAnswerByQuestionId(@PathVariable("questionId") Long questionId) {
		return answerService.getAnswerByQuestionId(questionId);
	}
	
	// api for modifying an answer
	@PutMapping("update/{answerId}")
	@CrossOrigin(origins = "*")
	public Answer modifyAnswer(@PathVariable("answerId") Long answerId, @RequestBody Answer answer ) {
		return answerService.modifyAnswer(answerId, answer);
	}
	
	// api for deleting an answer
	@DeleteMapping("/delete/{answerId}")
	@CrossOrigin(origins = "*")
	public String deleteMyAnswer(@PathVariable("answerId") Long answerId) {
		return answerService.deleteMyAnswer(answerId);
	}
	
	// api for deleting all answers
	@DeleteMapping("/delete/all")
	@CrossOrigin(origins = "*")
	public String deleteAllMyAnswers() {
		return answerService.deleteAllMyAnswers();
	}
	
	// api for getting answer by QuestionId
		@GetMapping("/count/{questionId}")
		@CrossOrigin(origins = "*")
		public int getAnswersCount(@PathVariable("questionId") Long questionId) {
			return answerService.getNoOfAnswers(questionId);
		}
	
	@GetMapping("/user/{userId}")
	@CrossOrigin(origins = "*")
	public List<Answer> getAnswersByUserId(@PathVariable("userId") Long userId) {
		return answerService.getAnswersByUserId(userId);
	}
	
	@GetMapping("/count")
	@CrossOrigin(origins = "*")
	public int countTotalAnswers() {
		return answerService.getTotalAnswers();
	}


	@GetMapping("/recent/{questionId}")
	@CrossOrigin(origins = "*")
	public List<Answer> sortByRecent(@PathVariable("questionId") Long questionId) {
		return answerService.sortByRecent(questionId);
	}

//	@PutMapping("/best/{answerId}")
//	@CrossOrigin(origins = "*")
//	public String modifyBest(@PathVariable("answerId") Long answerId, @RequestBody Answer ans) {
//		  return answerService.modifyBest(answerId, ans.isBestAnswer());
//	}
//
}
