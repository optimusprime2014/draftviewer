package com.dv.flow.util;

import com.dv.AppConfiguration;
import com.dv.controller.model.Response;
import com.dv.controller.model.ResponseStatus;
import com.dv.controller.model.request.Contact;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Slf4j
@Service
public class EmailService {

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    private JavaMailSender javaMailSender;

    public Response sendEmail(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(contact.getEmail());
        message.setSubject(String.join(" ", appConfiguration.getAppName(), contact.getName(), "said that:"));
        message.setText(contact.getMessage());

        log.info(String.join(" ", "Email to", contact.getEmail(), "was send"));
        javaMailSender.send(message);

        return Response.builder().build()
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join("Mail message for ", contact.getName(), "was send"));
    }
}
