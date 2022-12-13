package com.jeff.mail.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class MailDto {

    @NotBlank
    @Email
    private String mailTo;
    @NotBlank
    private UUID mailId;
    @NotBlank
    private UUID confirmationCode;

}
