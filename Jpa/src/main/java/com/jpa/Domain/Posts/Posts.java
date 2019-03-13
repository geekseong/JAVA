package com.jpa.Domain.Posts;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
    인자가 없는 기본생성자를 만드는 어노테이션으로 엑세스레벨은 접근 지정자를 나타낸다.
    디폴트는 public이다.
    protected Posts(){} 와 같은 효과를 나타낸다.
*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)

/*
    테이블과 링크될 클래스임을 나타냄.
    언더스코어로이름을 매칭한다 ex) salesManager -> sales_manager table
 */

@Entity
@Getter
public class Posts extends BaseTImeEntity {

    // @Id는 PK 필드를 나타낸다.
    // @GeneratedValue PK 생성 규칙을 나타낸다.
    // 기본값은 AUTO로 auto_increment와 같이 증가하는 정수형 값이 된다.
    @Id
    @GeneratedValue
    private Long id;


    // @Column을 선언한다면 클래스의 필드는 테이블 필드로 매핑됨을 나타낸다.
    // length 속성은 컬럼의 최대 크기를 나타냄
    @Column(length = 500, nullable = false)
    private String title;

    // columnDefinition 속성은 text 타입의 필드라는것을 뜻함.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    private String author;

    @Builder
    public Posts(String title, String contents, String author){
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
}

/*

    Tip)
    웬만하면 Entity의 PK는 Long 타입의 Auto_increment를 추천(MySQL 기준으로 이렇게 하면 bigint 타입이 됩니다.).

    주민등록번호와 같은 비지니스상 유니크키나, 여러키를 조합한 복합키로 PK를 잡을 경우 난감한 상황이 종종 발생합니다.
    (1) FK를 맺을때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나더 둬야하는 상황이 발생합니다.
    (2) 인덱스에 좋은 영향을 끼치지 못합니다.
    (3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야하는 일이 발생합니다.
    주민등록번호, 복합키 등은 유니크키로 별도로 추가하시는것을 추천드립니다.


    궁금증1)
        setter도 없는 상황에서 값을 어떻게 채워서 데이터베이스에 Insert할거냐?

    답변)
        생성자를 통 최종값 채운 후 데이터에비스에 insert하는것이며, 값 변경이 필요한 경우에는
        해당 이벤트에 맞는 public 매서드를 호출하여 변경하는것을 전제로함.

        여기서 생성자 대신 빌더가 제공되며, 생성시점에 값을 채워주는 역할은 똑같다.
        다만 생성자로 값을 채울경 채워야할 필드가 무엇인지 알 수 없습니다.


        #생성자로 값을 채는 경우
            public Example(String a, String b){
                this.a = a;
                this.b = b;
            }

        #빌더로 값을 채우는 경우

            Example.builder()
                .a(a)
                .b(b)
                .build();


 */