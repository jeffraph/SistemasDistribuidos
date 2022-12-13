package com.jeff.mail.service;

import com.jeff.mail.consumer.MailConsumer;
import com.jeff.mail.enums.MailStatus;
import com.jeff.mail.models.MailModel;
import com.jeff.mail.repositories.MailRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MailService {/*

    @Autowired
    MailRepository mailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String mail) {

        MailModel mailModel = new MailModel();
        UUID code = UUID.randomUUID();
        mailModel.setConfirmationCode(code);
        //mailModel.setMailDate(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            //message.setFrom("");

            message.setTo("");
            message.setSubject("Código de confirmação");
            message.setText("Código: " + code);
            emailSender.send(message);

            mailModel.setMailStatus(MailStatus.SENT);
        } catch (MailException e){
            mailModel.setMailStatus(MailStatus.ERROR);
        } finally {
            mailRepository.save(mailModel);
        }
    }*/
}
