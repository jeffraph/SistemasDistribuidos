package com.jeff.mail.models;

import com.jeff.mail.enums.MailStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "MAIL_TABLE")
public class MailModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID mailId;
    private UUID confirmationCode;
    private String mail;
    private MailStatus mailStatus;

}
