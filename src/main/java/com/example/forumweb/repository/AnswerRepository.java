package com.example.forumweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forumweb.model.Answer;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	@Query(value = "SELECT * FROM answer WHERE question_id = ?1 order by answer_id desc", nativeQuery = true)
	List<Answer> getAnswerByQuestionId(Long questionId);
	
	@Query(value = "SELECT COUNT(*) FROM answer WHERE question_id = ?1", nativeQuery = true)
	int getAsnwersCount(Long questionId);

	@Query(value = "Select * from answer where user_id = ?1", nativeQuery = true)
	List<Answer> getAnswersByUserId(Long userId);

	@Query(value = "SELECT COUNT(*) FROM answer", nativeQuery = true)
	int getTotalAnswers();

	@Query(value = "select * from answer where question_id = ?1 order by answer_id DESC", nativeQuery = true)
    List<Answer> sortByRecent(Long questionId);
}
