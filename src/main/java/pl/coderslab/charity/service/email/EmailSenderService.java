package pl.coderslab.charity.service.email;

public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body);
}
