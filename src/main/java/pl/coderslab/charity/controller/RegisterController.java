package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.service.register.RegisterServiceImpl;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final RegisterServiceImpl registerService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register",new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("register") RegisterDto register,
                               BindingResult bindingResult) {
        registerService.saveNewNotConfirmedUser(register);

        return "register-confirmation";
    }

}
