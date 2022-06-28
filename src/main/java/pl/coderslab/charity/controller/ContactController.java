package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.pojo.ContactPojo;
import pl.coderslab.charity.service.email.EmailSenderService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ContactController {

    private final EmailSenderService senderService;

    @PostMapping("/contact")
    public String contact(ContactPojo contact){

        senderService.sendEmail("charity.app.mail@gmail.com",
                "Message from " + contact.getName() + " " + contact.getSurname(),
                contact.getMessage());

        return "contact-confirmation";
    }
}
