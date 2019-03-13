package com.jpa.Domain.Posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*

    Entity 들의 상위 클래스가 되어 Entity들의 createdDate, mofifiedDate 를 자동으로 관리하는 역할을 합니다.

    @MappedSuperclass
        -> JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록하는 어노테이션

    @EntityListeners
        -> BaseTimeEntity 클래스에 auditing  기능을 포함시킵니다.

 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
