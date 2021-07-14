package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//JpaRepository extends 하면 findAll, save 메소드 사용가능해짐
public interface UserRepository extends JpaRepository<User, Long> {
	//@EntityGraph: 쿼리수행시 Lazy조회가 아니고 Eager조회로 authorities정보를 같이 가져옴
	//참고:https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rorean&logNo=221595286107
   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByUsername(String username);
}