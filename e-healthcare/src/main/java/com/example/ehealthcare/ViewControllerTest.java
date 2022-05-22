package com.example.ehealthcare;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class ViewControllerTest {

	@GetMapping("/auth/login3")
	public String loginPage() {
		return "member/login3";
	}
	
	@GetMapping("/auth/signupStep1")
	public String signupStep1Page() {
		return "signupStep1.mustache";
	}
	
	@GetMapping("/auth/signupStep2")
	public String signupStep2Page() {
		return "member/signupStep2";
	}

	@GetMapping("/auth/signupStep2Doctor")
	public String signupStep2DoctorPage() {
		return "member/signupStep2Doctor";
	}

	@GetMapping("/auth/signupStep3")
	public String signupStep3Page() {
		return "member/signupStep3";
	}

	@GetMapping("/auth/signupStep4")
	public String signupStep4Page() {
		return "member/signupStep4";
	}

	@GetMapping("/auth/findId")
	public String findIdPage() {
		return "member/findId";
	}

	@GetMapping("/auth/findPw")
	public String findPwPage() {
		return "member/findPw";
	}


	@GetMapping("/main")
	public String mainPage() {
		return "main";
	}

	@GetMapping("/medicalField")
	public String medicalFieldPage() {
		return "medicalField";
	}

	@GetMapping("/medicalField2")
	public String medicalField2Page() {
		return "medicalField2";
	}
}
