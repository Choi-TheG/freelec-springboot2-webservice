package com.jojoldu.book.springboot.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    @Column
    private String picture;
    
    @Enumerated(EnumType.STRING)    // @Enumerated(EnumType.STRING) = JPA로 데이터베이스에 저장할 때 Enum값을 어떤 형태로 저정할지 결정함. default = int가 된 숫자로 저장. 
    @Column(nullable = false)       // 숫자로 저장되면 DB로 확인할 때 그 값이 무슨 코드를 의미하는지 알 수 없기 때문에 STRING으로 저장될 수 있도록 선언
    private Role role;
    
    @Builder
    public User(String name, String email, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }
    
    public User update(String name, String picture){
        this.name=name;
        this.picture=picture;
        
        return this;
    }
    
    public String getRoleKey(){
        return this.role.getKey();
    }
}
