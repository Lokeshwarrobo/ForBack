package com.example.forumweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forumweb.model.Category;
import com.example.forumweb.model.Question;
import com.example.forumweb.model.QuestionSearch;

import org.springframework.transaction.annotation.Transactional;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	@Query(value = "SELECT * FROM question WHERE user_id = ?1", nativeQuery = true)
	List<Question> displayUserQuestion(Long userId);


	@Modifying
	@Transactional
	@Query(value = "DELETE FROM answer WHERE question_id = ?1", nativeQuery = true)
    void deleteAnswers(Long questionId);

	@Query(value = "SELECT COUNT(*) FROM question", nativeQuery = true)
	int getQuestionCount();

	@Query(value = "SELECT * FROM question where question LIKE %:questionSearch%", nativeQuery = true)
	List<Question> searchQuestion(String questionSearch);


	List<Question> findByCategoryId(Long categoryId);

	@Query(value = "SELECT COUNT(*) FROM answer WHERE question_id = ?1", nativeQuery = true)
	int getReplies(Long questionId);

	@Query(value = "SELECT * FROM question  WHERE category_id = ?1", nativeQuery = true)
	List<Question> getQuestionsByCategory(Long categoryId);

	
	@Query(value = "SELECT * FROM question ORDER BY views desc", nativeQuery = true)
	List<Question> trendingQuestions();

	
	@Query(value = "SELECT * FROM question ORDER BY question_id DESC", nativeQuery = true)
	List<Question> findAllQ();

	






	




}
