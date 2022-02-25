package com.example.forumweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forumweb.model.Category;
import com.example.forumweb.model.Question;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(value = "SELECT q.question_id, q.likes, q.question,  q.question_date, q.replies, q.views, q.user_name, q.user_id FROM question AS q INNER JOIN category AS c ON q.category_id = c.category_id WHERE c.category_id  = ?1", nativeQuery = true)
	List<Question> getQuestionsByCategory(Long categoryId);
	
	@Query(value = "SELECT * FROM category where category_name LIKE %:categoryName%", nativeQuery = true)
	List<Category> searchCategory(String categoryName);

}
