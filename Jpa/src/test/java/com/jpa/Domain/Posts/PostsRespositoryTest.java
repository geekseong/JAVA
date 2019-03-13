package com.jpa.Domain.Posts;


import com.jpa.Domain.Posts.Posts;
import com.jpa.Domain.Posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRespositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After
    public void cleanUp(){

        postsRepository.deleteAll();
    }

    @Test
    // 3개의 주석(//given, //when, //then)은 다음과 같은 내용을 나타냅니다.
    public void unitTestForPostsRepository(){

        // given -> 테스트 기반 환경을 구축하는 단계
        postsRepository.save(Posts.builder()
                .title("타이틀 입니다")
                .contents("콘텐츠 입니다")
                .author("geekseong")
                .build());

        // when -> 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        // then -> 테스트 결과 검증
        Posts post = postsList.get(0);
        assertThat(post.getTitle(), is("타이틀 입니다"));
        assertThat(post.getContents(), is("콘텐츠 입니다"));

    }
}

