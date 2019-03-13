package com.jpa.Webservice.Dto.Posts;

import com.jpa.Webservice.Domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*

    Controller 에서 @RequestBody 로 외부에서 데이터를 받는 경우에는 기본생성자 + set 메소드를 통해서만 값이 할당됨.
    그래서 이때만 setter를 허용

    테이블과 매핑되는 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨.
    Entity 클래스는 가장 Core 한 클래스.
    수많은 서비스 클래스나 비지니스 로직들이 Entity 클래스를 기준으로 동작.
    Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반명 Request 와 Response 용 DTO 는 View 를 위한 클래스라 정말 자주 변경이 필요.

    따라서 View Layer 와 DB Layer 를 철저하게 역할 분리하는게 좋음.

 */
@Setter
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String contents;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String contents, String author){
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .contents(contents)
                .title(title)
                .author(author)
                .build();
    }
}
