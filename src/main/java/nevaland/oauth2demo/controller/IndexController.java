package nevaland.oauth2demo.controller;

import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal KakaoOAuth2User kakaoOAuth2User, Model model) {
        model.addAttribute("userId", Optional.ofNullable(kakaoOAuth2User)
                                                         .map(KakaoOAuth2User::getName)
                                                         .orElse(null));
        if(kakaoOAuth2User != null){
            Optional<User> foundUser = userService.findOne(Long.parseLong(kakaoOAuth2User.getName(), 10));
            if(foundUser.isEmpty()) {
                User user = new User();
                return "redirect:/user/new";
            }
            else {
                model.addAttribute("nickname", foundUser.get().getName());
            }
        }
        return "index";
    }
}
