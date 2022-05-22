package com.example.ehealthcare.web;

import javax.validation.Valid;

import com.example.ehealthcare.domain.user.User;
import com.example.ehealthcare.service.AuthService;
import com.example.ehealthcare.web.dto.auth.SignupDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드를 DI 할때 사용(final 필드를 따름)
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {

	private final AuthService authService;

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "login";
	}

	@GetMapping("/auth/findId")
	public String findIdForm() {
		return "findId";
	}


	@GetMapping("/auth/findPw")
	public String findPwForm() {
		return "findPw";
	}


	@GetMapping("/auth/signupStep1")
	public String signupStep1Form() {
		return "signupStep1";
	}

	@GetMapping("/auth/signupStep2")
	public String signupStep2Form() {
		return "signupStep2";
	}

	@GetMapping("/auth/signupStep2Doctor")
	public String signupStep2DoctorForm() {
		return "signupStep2Doctor";
	}


	@GetMapping("/auth/signupStep3")
	public String signupStep3Form() {
		return "signupStep3";
	}


	@GetMapping("/auth/signupStep4")
	public String signupStep4Form() {
		return "signupStep4";
	}

	@GetMapping("/auth/login2")
	public String login2Form() {
		return "login2";
	}


	@GetMapping("/main")
	public String menuForm() {
		return "menu";
	}


	@GetMapping("/auth/main")
	public String menu2Form() {
		return "menu";
	}



	@PostMapping("/auth/signupStep2")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)
		// @Valid 유효성 검사, BindingResult 클래스:
		// User < - SignupDto(회원가입 시 SignupDto에 있는 객체에 값 넣기)
		User user = signupDto.toEntity(); // 생성
		authService.회원가입(user); // DB에 집어넣기(service 필요)
		//System.out.println(userEntity);
		// 로그를 남기는 후처리!
		//return "member/signupStep4.mustache";
		return "signupStep4";

	}


}
