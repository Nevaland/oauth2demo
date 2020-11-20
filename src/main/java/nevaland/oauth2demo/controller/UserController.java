package nevaland.oauth2demo.controller;

import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public KakaoOAuth2User user(@AuthenticationPrincipal KakaoOAuth2User kakaoOAuth2User) {
        System.out.println(kakaoOAuth2User);
        return kakaoOAuth2User;
    }

}
