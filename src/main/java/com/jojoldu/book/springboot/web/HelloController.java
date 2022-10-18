package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                         // @RestController = 컨트롤러를 JSON에 반환하는 컨트롤러로 만들어 줌
public class HelloController {          // 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용하게 해줌

    @GetMapping("/hello")               // @GetMapping = HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줌
    public String hello(){              // 예전에는 @RequestMapping(method=RequestMethod.GET)으로 사용되었음.
        return "hello";
    }
}
