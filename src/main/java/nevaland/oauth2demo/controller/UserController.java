package nevaland.oauth2demo.controller;

import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal KakaoOAuth2User kakaoOAuth2User) {
        return Optional.ofNullable(kakaoOAuth2User)
                       .map(KakaoOAuth2User::getName)
                       .orElse(null);
    }

}
