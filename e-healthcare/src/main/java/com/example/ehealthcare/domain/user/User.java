package com.example.ehealthcare.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 디비에 테이블을 생성
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int num;
	
	@Column(length = 100,  unique = true) // OAuth2 로그인을 위해 칼럼 늘리기, unuque(중복 불가)
	private String id;// 아이디

	@Column(nullable = false) // null 불가능
	private String pass; //비번 //VARCHAR(32)

	// 비번확인 pssword
	private String password; //비번

	// null 불가능(프론트에서 막았지만, 포스트맨 등에서 접근 할 수 있으므로 백엔드에서도 막아야 함)
	@Column(nullable = false)
	private String name;


	@Column(nullable = false)
	private String email; //VARCHAR(255)

	// 추가
	private String email1;
	// 추가
	private String email2;

	private String phone;

	
	 // 나는 연관관계의 주인이 아니다. 그러므로 테이블에 칼럼을 만들지마.
	// User를 Select할 때 해당 User id로 등록된 image들을 다 가져와
	// Lazy = User를 Select할 때 해당 User id로 등록된 image들을 가져오지마 - 대신 getImages() 함수의 image들이 호출될 때 가져와!!
	// Eager = User를 Select할 때 해당 User id로 등록된 image들을 전부 Join해서 가져와!!
	
	private LocalDateTime createDate; //TIMESTAMP

	private String role; // 권한

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createDate() {

		this.createDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ",  email=" + email + ", phone=" + phone + ", createDate=" + createDate + "]";
	}
	
}
