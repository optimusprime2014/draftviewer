package com.dv.service.util;

import com.dv.AppConfiguration;
import com.dv.controller.data.resp.Response;
import com.dv.controller.data.resp.ResponseStatus;
import com.dv.controller.data.req.RequestContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailUtils {

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    private JavaMailSender javaMailSender;

    public Response sendEmail(RequestContact requestContact) {

        javaMailSender.send(prepareMail(requestContact));

        javaMailSender.send(prepareMailCopy(requestContact));

        return Response.builder().build()
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join("Mail message for [", requestContact.getName(), "] was send"));
    }

    private SimpleMailMessage prepareMail(RequestContact rc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(rc.getEmail());
        message.setSubject(String.join(" ", appConfiguration.getAppName(), ": You sent message:"));
        message.setText(rc.getMessage());
        return message;
    }

    private SimpleMailMessage prepareMailCopy(RequestContact rc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(appConfiguration.getMailto());
        message.setSubject(String.join(" ", appConfiguration.getAppName(), ": User [", rc.getName(), "] said that:"));
        message.setText(rc.getMessage());
        return message;
    }
}
