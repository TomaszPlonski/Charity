package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.FormDto;
import pl.coderslab.charity.service.form.FormService;

import javax.validation.Valid;

@SessionAttributes("form")
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/form")
public class DonationController {

    private final FormService formService;

    @GetMapping
    public String formGetAction(Model model){
        model.addAttribute("form",formService.createFormDto());
        return "form/form1";
    }

    @PostMapping(params = "form1Submit")
    public String form1Submit(@Valid @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        return "form/form2";
    }

    @PostMapping(params = "form2Submit")
    public String form2Submit(@Valid @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        return "form/form3";
    }
    @PostMapping(params = "form2Back")
    public String form2Back(@Valid @ModelAttribute("form") FormDto form,
                            BindingResult bindingResult){
        return "form/form1";
    }

    @PostMapping(params = "form3Submit")
    public String form3Submit(@Valid @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        return "form/form4";
    }
    @PostMapping(params = "form3Back")
    public String form3Back(@Valid @ModelAttribute("form") FormDto form,
                            BindingResult bindingResult){
        return "form/form2";
    }

    @PostMapping(params = "form4Submit")
    public String form4Submit(@Valid @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        return "form/form5";
    }
    @PostMapping(params = "form4Back")
    public String form4Back(@Valid @ModelAttribute("form") FormDto form,
                            BindingResult bindingResult){
        return "form/form3";
    }

    @PostMapping(params = "form5Submit")
    public String form5Submit(@Valid @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        formService.saveForm(form);
        return "form/form-confirmation";
    }
    @PostMapping(params = "form5Back")
    public String form5Back(@Valid @ModelAttribute("form") FormDto form,
                            BindingResult bindingResult){
        return "form/form4";
    }


}
