package com.example.ehealthcare.config.auth;

import com.example.ehealthcare.domain.user.User;
import com.example.ehealthcare.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
// 스프링 시큐리티
@RequiredArgsConstructor
@Service // IoC에 등록(UserDetailsService를 새로 만든 PrincipalDetailsService로 대체하여 로그인 진행)
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	// 1. 패스워드는 알아서 체킹하니까(시큐리티가 확인해줌) 신경쓸 필요 없다.
	// 2. 리턴이 잘되면 자동으로 UserDetails 타입을 세션으로 만든다.
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		// username이 존재하는지 확인
		User userEntity = userRepository.findById(id);
		
		if(userEntity == null) { // username 못찾았으면
			return null;
		}else {
			return new PrincipalDetails(userEntity); // UserDetails 타입으로 리턴하기
		}
	}

}
