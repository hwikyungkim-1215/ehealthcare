package com.example.ehealthcare.web;

import com.example.ehealthcare.config.auth.PrincipalDetails;
import com.example.ehealthcare.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;



	/*	세션정보 찾기를 통해 회원 정보 변경하기!
		/auth/login -> username이 존재하면? -> PrincipalDetails에서 세션 저장
		-> autnentication에 접근(AuthenticationPrincipal 어노테이션 이용) -> 세션 접근!!
 	*/

	// 회원 정보 변경
	// model에 담아서 세션정보 보내기-> pom.xml에서 처리했으므로(시큐리티 태그 라이브러리, header)할 필요 없음!
	@GetMapping("/user/{num}/update")
	public String updateForm(@PathVariable int num, @AuthenticationPrincipal PrincipalDetails principalDetails) {


		System.out.println("세션 정보 : "+principalDetails.getUser());

		return "user/update";
	}

}
