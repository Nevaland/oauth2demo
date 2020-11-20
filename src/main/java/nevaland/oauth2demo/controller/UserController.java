package nevaland.oauth2demo.controller;

import nevaland.oauth2demo.domain.User;
import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import nevaland.oauth2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/new")
    public String newUser() {
        return "setNicknameForm";
    }

    @PostMapping("/user/new")
    public String registerUser(@AuthenticationPrincipal KakaoOAuth2User kakaoOAuth2User,
                               @RequestParam(value = "nickname") String nickname) {
        if(kakaoOAuth2User != null) {
            User user = new User(Long.parseLong(kakaoOAuth2User.getName(), 10), nickname);
            userService.join(user);
        }
        return "redirect:/";
    }

}
