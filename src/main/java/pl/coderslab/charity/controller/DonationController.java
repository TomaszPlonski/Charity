package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.FormDto;
import pl.coderslab.charity.service.form.FormService;
import pl.coderslab.charity.service.validators.formGroups.Form1Validation;
import pl.coderslab.charity.service.validators.formGroups.Form2Validation;
import pl.coderslab.charity.service.validators.formGroups.Form3Validation;
import pl.coderslab.charity.service.validators.formGroups.Form4Validation;

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
    public String form1Submit(@Validated({Form1Validation.class}) @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form/form1";
        }
        return "form/form2";
    }

    @PostMapping(params = "form2Submit")
    public String form2Submit(@Validated({Form2Validation.class})  @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form/form2";
        }
        return "form/form3";
    }
    @PostMapping(params = "form2Back")
    public String form2Back(@ModelAttribute("form") FormDto form){
        return "form/form1";
    }

    @PostMapping(params = "form3Submit")
    public String form3Submit(@Validated({Form3Validation.class}) @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form/form3";
        }
        return "form/form4";
    }
    @PostMapping(params = "form3Back")
    public String form3Back(@ModelAttribute("form") FormDto form){
        return "form/form2";
    }

    @PostMapping(params = "form4Submit")
    public String form4Submit(@Validated({Form4Validation.class})  @ModelAttribute("form") FormDto form,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form/form4";
        }
        return "form/form5";
    }
    @PostMapping(params = "form4Back")
    public String form4Back(@ModelAttribute("form") FormDto form){
        return "form/form3";
    }

    @PostMapping(params = "form5Submit")
    public String form5Submit(@ModelAttribute("form") FormDto form){
        formService.donationSuccess(form);
        return "form/form-confirmation";
    }
    @PostMapping(params = "form5Back")
    public String form5Back(@ModelAttribute("form") FormDto form){
        return "form/form4";
    }


}
