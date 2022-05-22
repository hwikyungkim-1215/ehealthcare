package com.example.ehealthcare.web.dto.user;

import javax.validation.constraints.NotBlank;

import com.example.ehealthcare.domain.user.User;
import lombok.Data;

// usernamem, useremail은 수정 불가
// UserApiController
@Data
public class UserUpdateDto {
	@NotBlank
	private String name; // 필수
	@NotBlank
	private String pass; // 필수

	
	// 조금 위함함. 코드 수정이 필요할 예정
	// 필수로 받지 않아도 되는 것들이 있으므로 toEntity()로 정의하면 위험함
	public User toEntity() {
		return User.builder()
				.name(name) // 이름을 기재 안했으면 공백으로 값이 전댈되어 문제생김 -> Validation 체크 필요!
				.pass(pass) // 패스워드를 기재 안했으면 공백으로 값이 전달되어 문제생김 ->  Validation 체크 필요
				.build();
	}
}
