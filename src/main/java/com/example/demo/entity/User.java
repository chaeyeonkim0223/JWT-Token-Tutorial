package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity//database table과 1:1로 매핑되는 객체임을 의미
@Table(name = "user")//table 명 user
@Getter
@Setter
@Builder
@AllArgsConstructor//생성자
@NoArgsConstructor
public class User {

   @JsonIgnore
   @Id//primary key
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)//자동증가
   private Long userId;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @JsonIgnore
   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @JsonIgnore
   @Column(name = "activated")
   private boolean activated;

   @ManyToMany
   @JoinTable(//user객체와 권한객체의 다대다 관계-> 1:N N:1 관계의 조인테이블로 정의하겠다.
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;
}
