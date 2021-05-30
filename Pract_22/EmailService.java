package Pract_22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void SendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("liza-gri2001@yandex.ru");
        message.setSubject("Test Simple Email");
        message.setText("Simple Email");
        this.emailSender.send(message);
        System.out.println("Email sent");
    }
}
