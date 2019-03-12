package com.jpa.Domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;


/*
    보통 mybatis진영에서 dao라고 불리는 데이터베이스 레이어입니다.
    jpa에서는  repository 라고 부르며 인터페이스로 생성합니다.
    인터페이스를 추가하고  JpaRepository<Entity타입, PK타입> 을 상속하면 CURD메서드가 기본적으로 생성됩니다.
    특별히 @Repository를 추가 할 필요도 없습니다.

 */
public interface PostsRepository extends JpaRepository<Posts, Long> { }
