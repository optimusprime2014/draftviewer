package com.dv.controller;

import com.dv.controller.model.Response;
import com.dv.controller.model.ResponseStatus;
import org.joda.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
public class RootController {
    @GetMapping
    public Response status() {
        return Response.builder().build()
                .setStatus(ResponseStatus.OK)
                .setMessage("Server is running: " + LocalDateTime.now());
    }
}
