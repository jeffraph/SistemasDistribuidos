package com.jeff.mail.consumer;

import com.jeff.mail.enums.MailStatus;
import com.jeff.mail.models.MailModel;
import com.jeff.mail.repositories.MailRepository;
import com.jeff.mail.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MailConsumer {

    MailModel mailModel = new MailModel();
    UUID code = UUID.randomUUID();
    @Autowired
    MailRepository mailRepository;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    MailService mailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload String email) {
        SimpleMailMessage message = new SimpleMailMessage();

        try{
            message.setTo(email);
            message.setSubject("Código de confirmação");
            message.setText("Código: " + code);
            emailSender.send(message);
            mailRepository.save(mailModel);
        }catch (MailException e){
            mailModel.setMailStatus(MailStatus.ERROR);
        } finally {
            mailRepository.save(mailModel);
        }
    }
}
