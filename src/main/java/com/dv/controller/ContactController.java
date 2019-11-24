package com.dv.controller;

import com.dv.controller.model.Response;
import com.dv.controller.model.request.Contact;
import com.dv.flow.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/contact", produces = "application/json; charset=UTF-8")
public class ContactController {

    @Autowired
    EmailService emailService;

    @PostMapping
    public Response contact(@Valid @RequestBody Contact contact) {
        return emailService.sendEmail(contact);
    }
}
