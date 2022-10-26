package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing                                                      // JPA Auditing 활성화
@SpringBootApplication                                                  // 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성 모두 자동으로 설정됨.
public class Application {                                              // 해당 어노테이션(@SpringBootApplication)이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야 함.
    public static void main(String[] args){                             // 앞으로 만들 프로젝트의 메인 클래스
        SpringApplication.run(Application.class, args);                 // SpringApplication.run = 내장 WAS(Web Application Server, 웹 애플리케이션 서버, 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것) 실행-> 톰캣 설치 필요 X

    }                                                                   //
}
