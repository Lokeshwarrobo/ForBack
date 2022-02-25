package com.example.forumweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.forumweb.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "Select emp_id from user where emp_id = ?1 or email = ?1", nativeQuery = true)
	String findByUserName(String userName);

	@Query(value = "Select user_id from user where emp_id = ?1", nativeQuery = true)
	Long findUserId(String userName);
	
	@Query(value = "Select password from user where emp_id = ?1", nativeQuery = true)
	String findByUserPassword(String userName);
	
	@Query(value = "SELECT COUNT(*) FROM user", nativeQuery = true)
	int getUsersCount();

	String findByEmail(String email);

	@Query(value = "Select user_name from user where emp_id = ?1 or email = ?1", nativeQuery = true)
	String getUserName(String userName);

	@Query(value = "SELECT emp_id FROM user WHERE emp_id = ?1 OR email = ?1", nativeQuery = true)
	String getEmpId(String empId);

}
