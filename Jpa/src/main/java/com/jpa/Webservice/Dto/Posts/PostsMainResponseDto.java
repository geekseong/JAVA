package com.jpa.Webservice.Dto.Posts;

import com.jpa.Webservice.Domain.Posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {


    private Long id;
    private String title;
    private String contents;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity){
        id = entity.getId();
        title = entity.getTitle();
        contents = entity.getContents();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}

/*
    TIP) Entity가 toDto와 같은 메소드로 dto를 반환하면 되지 않나?
        DTO는 Entity를 사용해도 되지만, Entity는 DTO에 대해 전혀 모르게 구성 해야함.
        Entity는 말 그대로 가장 core한 클래스 인 반면, DTO는 View 혹은 외부 요청에 관련있는 클래스.
        Entity가 DTO를 사용하게 되면, 그때무터 View/외부요청에 따라 DTO뿐만 아니라 Entity까지 변경이 필요하게 됩니다.
        프로젝트 규모가 커져 프로젝트를 분리해야 할떄도 Entity가 DTO를 의존하고 있으면 분리하기 굉장히 어렵기 때문에 DTO가 Entity를 의존하도록 작성해야함.

 */