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

        if (bindingResult.hasErrors()) {
            return "register";
        }
        registerService.sentEmailIfAvailable(register);

        return "register-confirmation";
    }

    @GetMapping("/ver/{token}")
    public String verify(@PathVariable String token, Model model) {
            try{
                registerService.verification(token);
            } catch (IllegalArgumentException e){
                return "redirect:/404";
            }
        return "redirect:/verification";
    }

    @GetMapping("/verification")
    public String verificationSuccess(){
        return "register-finished";
    }

    @GetMapping("/404")
    public String verificationFail(){
        return "404";
    }

}
