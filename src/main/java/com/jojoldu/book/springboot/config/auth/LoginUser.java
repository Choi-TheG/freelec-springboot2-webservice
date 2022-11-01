package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)          // @Target(ElementType.PARAMETER) = 이 어노테이션이 생성될 수 있는 위치 지정. 여기서는 PARAMETER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할 수 있음
@Retention(RetentionPolicy.RUNTIME)     // 이 외에도 클래스 선언문에 쓸 수 있는 TYPE 등이 있음
public @interface LoginUser {           // @interface = 이 파일을 어노테이션 클래스로 지정. LoginUser라는 이름을 가진 어노테이션이 생성된 것(React에 엘리먼트 같은건가)

}
