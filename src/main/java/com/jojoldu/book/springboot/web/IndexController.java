package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
//    private final HttpSession httpSession;

    @GetMapping("/")                // @LoginUser SessionUser user = 기존(user)에 httpSession.getAttribute("user")로 가져오던 세션 정보 값을 개선. 이제 어느 컨트롤러든지 @LoginUser 사용 시 세션 정보 가져올 수 있음
    public String index(Model model, @LoginUser SessionUser user){                           // Model = 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
        model.addAttribute("posts", postsService.   // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달합니다
                findAllDesc());
//        SessionUser user = (SessionUser) httpSession.           // (SessionUser)HttpSession.getAttribute("user") = CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성
//                getAttribute("user");                     // 로그인 성공 시, httpSession.getAttribute("user")에서 값을 가져올 수 있음
        if(user != null){                                         // if(user!=null) = 세션에 저장된 값이 있을 때만 model에 userName으로 등록. 저장된 값이 없다면 model엔 아무런 값이 없기에 로그인 버튼 출력
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
/*
    @GetMapping("/")
    public String index(){
        return "index";
    }
*/
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model
                              model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
