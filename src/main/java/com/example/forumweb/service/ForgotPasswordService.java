package com.example.forumweb.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.forumweb.model.ForgotPassword;
import com.example.forumweb.repository.ForgotPasswordRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class ForgotPasswordService {



	private PasswordEncoder passwordEncoder;
	
	public ForgotPasswordService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	private ForgotPasswordRepository forgotPasswordRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public String generateToken(String email) {

		SimpleMailMessage msg = new SimpleMailMessage();

		String userName = forgotPasswordRepo.findUserNameByMail(email);

		String uri = "http://localhost:3000/resetpassword/";
		if(email.equals(forgotPasswordRepo.findEmail(email))) {
			String token = "";
			Random random = new Random();
			System.out.println(uri);
			for(int i = 0; i <= 20; i++) {
				token = token+(char)(random.nextInt(26)+97);
			}

			uri = uri+token;
			
		     ForgotPassword fp = new ForgotPassword();


		     if(email.equals(forgotPasswordRepo.findMail(email))) {
		    	 forgotPasswordRepo.deleteEmail(email);
				 fp.setEmail(email);
				 fp.setToken(token);
		    	 forgotPasswordRepo.save(fp);
				 msg.setTo(email);
				 msg.setSubject("Reset Password Link");
				 msg.setText("Dear " + userName + "," +
						 "\n" + "\n" +
						 "Please find the password reset link below:" +
						 "\n" +uri + "\n" +"\n" + " Thanks ," + "\n" + "Admin");
				 javaMailSender.send(msg);
		    	 return "Token sent to mail";
		     }
		     else {
				 fp.setEmail(email);
				 fp.setToken(token);
		    	 forgotPasswordRepo.save(fp);
				 msg.setTo(email);
				 msg.setSubject("Reset Password Link");
				 msg.setText("Dear" + userName +"," +
						 "\n" +
						 "Please find the password reset link below:" +
						 "\n" +uri);
				 javaMailSender.send(msg);

		     }
			msg.setTo(email);
			msg.setSubject("Reset Password Link");
			msg.setText("Dear " + userName + "," +
					"\n" +
					"Please find the password reset link below: " +
					"\n" +uri);
			javaMailSender.send(msg);


			return "Token sent to mail";
			 
		 }
		 return "Email not found";
	
	}


	
	public String changePassword(ForgotPassword fp) {

		String mail = forgotPasswordRepo.findEmailByToken(fp.getToken());

		String token = forgotPasswordRepo.findTokenByEmail(mail);
		
		if(token.equals(fp.getToken())) {
			System.out.println(token);
			if(fp.getPassword().equals(fp.getConformPassword())) {
				String password = passwordEncoder.encode(fp.getPassword());
				forgotPasswordRepo.updateUserPassword(mail , password);
				forgotPasswordRepo.deleteEmail(mail);
			}
			else {
				return "Password Mismatch";
			}
			
		}
		else {
			return "Enter correct token";
		}
		
		return "Password Updated Successfully";
	}

	public List<ForgotPassword> getAll() {
		
		return forgotPasswordRepo.findAll();
	}

//	@Scheduled(fixedRate = 12000000)
//	public void deleteTokens(String mail) {
//		forgotPasswordRepo.deleteEmail(mail);
//	}
//
	
	

}
