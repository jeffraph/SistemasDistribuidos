package com.jeff.user.models;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "USERS_TABLE")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 16)
    UUID id;
    String username;
    String password;
    String mail;
}

