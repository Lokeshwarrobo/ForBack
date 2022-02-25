package com.example.forumweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.forumweb.model.ForgotPassword;


@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Long>{

	
	@Query(value = "SELECT f.token FROM forgot_password AS  f INNER JOIN user AS u ON u.email = f.email WHERE u.email = ?1 ", nativeQuery = true)
	String findTokenByEmail(String email);

	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET `password` = ?2  WHERE email = ?1", nativeQuery = true)
	void updateUserPassword(String email, String password);
	
	@Query(value = "SELECT u.email FROM user AS u LEFT OUTER JOIN forgot_password AS f ON f.email = u.email WHERE u.email = ?1", nativeQuery = true)
	String findEmail(String email);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM forgot_password WHERE email = ?1", nativeQuery = true)
	void deleteEmail(String email);

	@Query(value = "SELECT email FROM forgot_password WHERE token = ?1", nativeQuery = true)
	String findEmailByToken(String token);
	
	@Modifying
	@Transactional
	@Query(value = " delete from forgot_password where generated_at < DATE_SUB(2022-02-16 17:30:21 , INTERVAL 1 MINUTE )", nativeQuery = true)
	void deleteAftertime();

	@Query(value = "SELECT u.user_name FROM user AS u LEFT OUTER JOIN forgot_password AS f ON f.email = u.email WHERE u.email = ?1", nativeQuery = true)
	String findUserNameByMail(String mail);

	@Query(value = "select email from forgot_password where  email = ?1" , nativeQuery = true)
	String findMail(String mail);
}
