package com.dv;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfiguration {

    @Value("${draftviewo.appname}")
    private String appName;
}
