package com.example.forumweb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.forumweb.model.Category;
import com.example.forumweb.model.Question;
import com.example.forumweb.model.QuestionSearch;
import com.example.forumweb.repository.CategoryRepository;
import com.example.forumweb.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	public List<Question> displayAllQuestions() {
		List<Question> qs = questionRepo.findAll();
		List <Question> qp = new ArrayList<Question>();
		Iterator itr = qs.iterator();
		while(itr.hasNext()) {
			Question q = (Question) itr.next();
			q.setReplies(questionRepo.getReplies(q.getQuestionId()));
			qp.add(q);
		}
		
		return qp;
	}
	
	public List<Question> displayAllQuestion() {
		List<Question> qs = questionRepo.findAllQ();
		List <Question> qp = new ArrayList<Question>();
		Iterator itr = qs.iterator();
		while(itr.hasNext()) {
			Question q = (Question) itr.next();
			q.setReplies(questionRepo.getReplies(q.getQuestionId()));
			qp.add(q);
		}
		
		return qp;
	}

	public List<Question> displayUserQuestions(Long userId) {
		return questionRepo.displayUserQuestion(userId);
	}

	public Question modifyQuestion(Long questionId, Question question) {
		Question qs = questionRepo.findById(questionId).get();
		qs.setQuestion(question.getQuestion());
		return questionRepo.save(qs);
		
	}

	public Question createQuestion(Question question) {
		
		
		return questionRepo.save(question);
	}

	public String deleteQuestion(Long questionId) {
		questionRepo.deleteById(questionId);
		questionRepo.deleteAnswers(questionId);
		return "Deleted Successfully";
	}

	public String deleteAllQuestions() {
		 questionRepo.deleteAll();
		 return "Deleted All Successfully";
	}

	public Question getQuestionById(Long questionId) {
		
		return questionRepo.findById(questionId).get();
	}

	public int getQuestionCount() {
		return questionRepo.getQuestionCount();
	}
	
	public List<Question> searchQuestion(String questionSearch) {
		return questionRepo.searchQuestion(questionSearch);
	}

	public List<Question> getByCategory(Long categoryId) {
		return questionRepo.findByCategoryId(categoryId);	}

	public int increaseViews(Long questionId, int i) {
		Question qs = questionRepo.findById(questionId).get();
		qs.setViews(qs.getViews() + i);
		questionRepo.save(qs);
		return i;
	}

	public String increaseLikes(Long questionId, int likes) {
		Question qs = questionRepo.findById(questionId).get();
		
		if(qs.getLikes() >= 1) {
			return "Already liked";
		}
		else {
			qs.setLikes(likes);
			questionRepo.save(qs);
			return "Liked";
		}
		
		
	}

	public List<Category> getAllCategories() {
		
		return categoryRepo.findAll();
	}

	public List<Question> getQuestionsByCategory(Long categoryId) {
		
		return questionRepo.getQuestionsByCategory(categoryId);
	}

	public List<Question> trendingQuestions() {
	 
		List<Question> qs = questionRepo.trendingQuestions();
		List <Question> qp = new ArrayList<Question>();
		Iterator itr = qs.iterator();
		while(itr.hasNext()) {
			Question q = (Question) itr.next();
			q.setReplies(questionRepo.getReplies(q.getQuestionId()));
			qp.add(q);
		}
		
		return qp;
	}
	
	



}
