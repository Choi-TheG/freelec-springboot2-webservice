package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter                                                                 // @Getter = 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor                                                      // @NoArgsConstructor = 기본 생성자 자동 추가. public Posts(){}와 같은 효과
@Entity                                                                 // @Entity = 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
public class Posts extends BaseTimeEntity {

    @Id                                                                 // @Id = 해당 테이블의 PK 필드.
    @GeneratedValue(strategy = GenerationType.IDENTITY)                 // @GeneratedValue = PK의 생성 규칙을 나타냄. 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨,
    private Long id;                                                    // 스프링 부트 2.0 버전과 1.5 버전의 차이는 http://jojoldu.tistory.com/295 에 정리됨

    @Column(length = 500, nullable = false)                             // @Column = 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨. 기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용,
    private String title;                                               // 문자열의 경우 VARCHAR(255)가 기본값. 사이즈를 늘리고싶거나(ex: title), 타입을 TEXT로 변경하고 싶을 때(ex: content) 등의 경우에 사용

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    // Error! 클래스 이름을 Posts가 아닌 posts로 해서 void를 넣어야 정상작동이 되게 함(왜 그런진 모르겠음)
    @Builder                                                           // @Builder = 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
