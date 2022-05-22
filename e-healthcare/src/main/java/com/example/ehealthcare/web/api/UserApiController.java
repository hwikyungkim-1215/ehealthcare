package com.example.ehealthcare.web.api;

import javax.validation.Valid;

import com.example.ehealthcare.config.auth.PrincipalDetails;
import com.example.ehealthcare.domain.user.User;
import com.example.ehealthcare.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

// 회원가입 수정(제출 버튼 클릭시 update() 호출됐을 때 수정사항 처리하기)
@RequiredArgsConstructor
@RestController // 데이터로 응답
public class UserApiController {
	
	private final UserService userService;



}
