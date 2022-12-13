package com.jeff.mail.controller;

import com.jeff.mail.consumer.MailConsumer;
import com.jeff.mail.dto.MailDto;
import com.jeff.mail.models.MailModel;
import com.jeff.mail.repositories.MailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    @Autowired
    private MailConsumer mailConsumer;


    @PostMapping("/confirm")
    public ResponseEntity<MailModel> sendMail(@RequestBody MailDto mailDto) {
        MailModel mailModel = new MailModel();
        BeanUtils.copyProperties(mailDto, mailModel);
        mailConsumer.listen(String.valueOf(mailModel));
        return new ResponseEntity<>(mailModel, HttpStatus.CREATED);
    }
}
