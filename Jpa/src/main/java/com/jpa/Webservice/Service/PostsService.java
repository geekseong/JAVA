package com.jpa.Webservice.Service;

import com.jpa.Webservice.Domain.Posts.PostsRepository;
import com.jpa.Webservice.Dto.Posts.PostsMainResponseDto;
import com.jpa.Webservice.Dto.Posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PostsService {


    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}

/*
    TIP)
        controller 에서 dto.toEntity() 를 호출해도 되는데 굳이 service 에서 Dto를 받는이유는
        Controller 와 Service의 역할을 분리 하기 위함입니다.

        비지니스 로직 & 트렌젝션 관리는 모두 Service에서 관리하고, View 와 연동되는 부분은 Controller에서 담당하도록 구성합니다.

    TIP) 트렌젝션?
        일반적으로 DB 등록/수정/삭제 하는 service메소드는 @Transactional를 필수적으로 가져갑니다.
        이 어노테이션 이는일은 매소드 내에서 Exception 이 발생한다면, 메소드 내에서 이루어진 모든 DB작업을 초기회 시켜줍니다.

        참고 링크
        http://springmvc.egloos.com/495798

*/