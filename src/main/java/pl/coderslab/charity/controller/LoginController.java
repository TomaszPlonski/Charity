package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.security.UserService;


@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
