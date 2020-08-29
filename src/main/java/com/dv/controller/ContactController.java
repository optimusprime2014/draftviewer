package com.dv.controller;

import com.dv.controller.data.resp.Response;
import com.dv.controller.data.req.RequestContact;
import com.dv.service.util.EmailUtils;
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
    EmailUtils emailUtils;

    @PostMapping
    public Response sendMail(@Valid @RequestBody RequestContact requestContact) {
        return emailUtils.sendEmail(requestContact);
    }
}
