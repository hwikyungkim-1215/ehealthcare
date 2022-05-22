package com.example.ehealthcare.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// 저장소 필요
// 어노테이션이 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Integer>{ // <User,프라이마리 키 타입>
	// JPA query method 숫자로 찾기
	User findById(String id);
}
