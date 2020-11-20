package nevaland.oauth2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user/new")
    public String newUser() {
        return "setNicknameForm";
    }

    @PostMapping("/user/new")
    public String registerUser(@RequestParam(value = "nickname") String nickname) {
        System.out.println(nickname);
        return "redirect:/index";
    }

}
