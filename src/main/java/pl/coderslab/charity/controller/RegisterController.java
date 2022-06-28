package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.service.register.RegisterService;
import pl.coderslab.charity.service.register.RegisterServiceImpl;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register",new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("register") RegisterDto register,
                               BindingResult bindingResult) {
        registerService.registerNewUser(register);

        return "register-confirmation";
    }

    @GetMapping("/ver/{token}")
    public String verify(@PathVariable String token, Model model) {
            try{
                registerService.verification(token,1L);
            } catch (IllegalArgumentException e){
                return "404";
            }
        return "register-finished";
    }

}
