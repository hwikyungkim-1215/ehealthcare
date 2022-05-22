package com.example.ehealthcare.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.example.ehealthcare.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data //implements UserDetails, OAuth2User -> 일반 회원가입을 하던, 네이버로 회원가입을 하던 모두 PrincipalDetails여기에서 저장, 조회 가능!!
public class PrincipalDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private User user;

	public PrincipalDetails(User user) {
		this.user = user;
	}

	// 생성자 만들기
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
	}

	// 권한 : 한개가 아닐 수 있음. (3개 이상의 권한)
	// 하나가 아니므로 Collection으로..

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collector = new ArrayList<>();
		collector.add(() -> { return user.getRole();}); // 권한 넣어주기(람다식으로 쓰면 간단해짐)
		return collector;
	}


	@Override
	public String getPassword() {
		return user.getPass();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override // 계정 만료? -> false로 하지 말자(직접 서비스 할때 false로 사용하기)
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override // 계정 막혔니?
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override // 비밀번호 1년 만료?
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
