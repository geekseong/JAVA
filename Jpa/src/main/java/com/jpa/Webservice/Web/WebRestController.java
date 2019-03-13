package com.jpa.Webservice.Web;

import com.jpa.Webservice.Domain.Posts.PostsRepository;
import com.jpa.Webservice.Dto.Posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
     스프링 프레임워크에서 객체를 주입 받는 방법은3가지

        - @autowired
        - setter
        - 생성자

        이중 가장 권장하느 방법이 '생성자로 주입받는 방식' 입니다( @Autowired는 비 권장방식)

        @AllArgsConstructor 는 모든 필드를 인자값으로 하는 생서자를 Lombok에서 자동으로 대신 생성.
        의존성 관계가 변경될떄마다 생성자 코드를 계속해서 수정하는 번거로움을 해결.


 */
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
