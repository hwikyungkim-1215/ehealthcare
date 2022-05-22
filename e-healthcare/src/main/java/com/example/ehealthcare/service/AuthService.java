package com.example.ehealthcare.service;

import com.example.ehealthcare.domain.user.User;
import com.example.ehealthcare.domain.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;

// 회원가입 등록 service
@RequiredArgsConstructor
@Service // 1. IoC  2. 트랜잭션 관리
public class AuthService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional // Write(Insert, Update, Delete)
	public User 회원가입(User user) throws RuntimeException{
		// 회원가입 진행
		// (암호화)
		String rawPassword = user.getPass();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 비밀번호 암호화
		user.setPass(encPassword);
		user.setRole("ROLE_USER"); // 관리자 ROLE_ADMIN
		User userEntity = null;
		userEntity = userRepository.save(user);
		
		
		return userEntity;
	}
}
