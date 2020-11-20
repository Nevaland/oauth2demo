package nevaland.oauth2demo.controller;

import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal KakaoOAuth2User kakaoOAuth2User, Model model) {
        model.addAttribute("userId", Optional.ofNullable(kakaoOAuth2User)
                                                         .map(KakaoOAuth2User::getName)
                                                         .orElse(null));
        return "index";
    }
}
