package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.HomeService.HomeService;
import pl.coderslab.charity.service.HomeService.HomeServicePOJO;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute( "homeInfo",homeService.getInfoForHomePage());
        return "index";
    }

    @RequestMapping("/form")
    public String formAction(Model model){
        return "/form";
    }

}
