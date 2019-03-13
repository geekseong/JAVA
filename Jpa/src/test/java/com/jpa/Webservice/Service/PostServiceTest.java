package com.jpa.Webservice.Service;


import com.jpa.Webservice.Domain.Posts.Posts;
import com.jpa.Webservice.Domain.Posts.PostsRepository;
import com.jpa.Webservice.Dto.Posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private  PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveDtoToDBTable(){

        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("title")
                .contents("contents")
                .author("author")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts post = postsRepository.findAll().get(0);

        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(post.getContents()).isEqualTo(dto.getContents());
        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());

    }
}

