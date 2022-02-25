package com.example.forumweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forumweb.model.Category;
import com.example.forumweb.model.Question;
import com.example.forumweb.model.QuestionSearch;
import com.example.forumweb.repository.QuestionRepository;
import com.example.forumweb.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {
	
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QuestionService questionService;
	
	// api for displaying all questions
	@GetMapping("/all")
	@CrossOrigin(origins = "*")
	public List<Question> displayAllQuestions() {
		return questionService.displayAllQuestion();
	}
	
	// api for displaying a question based on userId
	@GetMapping("/all/{userId}")
	@CrossOrigin(origins = "*")
	public List<Question> displayUserQuestions(@PathVariable("userId") Long userId) {
		return questionService.displayUserQuestions(userId);
	}
	
	// api for modifying a question
	@PutMapping("/update/{questionId}")
	@CrossOrigin(origins = "*")
	public Question modifyQuestion(@PathVariable("questionId") Long questionId, @RequestBody Question question) {
		return questionService.modifyQuestion(questionId, question);
	}
	
	// api for creating a question
	@PostMapping("/create")
	@CrossOrigin(origins = "*")
	public Question createQuestion(@RequestBody Question question) {
		System.out.println(question);
		return questionService.createQuestion(question);
	}
	
	// api for deleting a question
	@DeleteMapping("/delete/{questionId}")
	@CrossOrigin(origins = "*")
	public String deleteQuestion(@PathVariable("questionId") Long questionId) {
		return questionService.deleteQuestion(questionId);
	}
	
	// api for deleting all questions
	@DeleteMapping("/deleteall")
	@CrossOrigin(origins = "*")
	public String deleteAllQuestions() {
		return questionService.deleteAllQuestions();
	}
	
	//api for getting question on question Id
	@GetMapping("/{questionId}")
	@CrossOrigin(origins = "*")
	public Question getQuestionById(@PathVariable("questionId") Long questionId) {
		return questionService.getQuestionById(questionId);
	}
	
	@GetMapping("/count")
	@CrossOrigin(origins = "*")
	public int getQuestionCount() {
		return questionService.getQuestionCount();
	}
	
	@GetMapping("/search/{question}")
	@CrossOrigin(origins = "*")
	public List<Question> searchQuestion(@PathVariable("question") String question) {
		return questionService.searchQuestion(question);
	}
	
	@GetMapping("/cat/{categoryId}")
	@CrossOrigin(origins = "*")
	public List<Question> getByCategory(@PathVariable("categoryId") Long categoryId) {
		return questionService.getByCategory(categoryId);
	}
	
	@PutMapping("/views/{questionId}")
	@CrossOrigin(origins = "*")
	public int increaseViews(@PathVariable("questionId") Long questionId, @RequestBody Question question) {
		System.out.println(question);
		return questionService.increaseViews(questionId, question.getViews());
	}
	
	@PutMapping("/likes/{questionId}")
	@CrossOrigin(origins = "*")
	public String increaseLikes(@PathVariable("questionId") Long questionId,  @RequestBody Question question) {
		return questionService.increaseLikes(questionId, question.getLikes());
	}
	
	@GetMapping("/cats")
	@CrossOrigin(origins = "*")
	public List<Category> getAllCategories() {
		return questionService.getAllCategories();
	}
	
	@GetMapping("/trend")
	@CrossOrigin(origins = "*")
	public List<Question> trendingQuestions() {
		return questionService.trendingQuestions();
	}
	
	

}
