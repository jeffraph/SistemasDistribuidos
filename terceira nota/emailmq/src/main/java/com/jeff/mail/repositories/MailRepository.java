package com.jeff.mail.repositories;

import com.jeff.mail.models.MailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MailRepository extends JpaRepository<MailModel, UUID> {

}
