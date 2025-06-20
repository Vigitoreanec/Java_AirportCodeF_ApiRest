package org.top.airportapidictionary.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.top.airportapidictionary.api.message.CommonApiMessage.StringMessage;

// StatusController - контроллер с обработчиками проверки статуса приложения
@RestController
@RequestMapping("api")
public class StatusController {

    @GetMapping("status")
    public StringMessage status() {
        return new StringMessage("server is running");
    }

    @GetMapping("ping")
    public StringMessage ping() {
        return new StringMessage("pong");
    }
}

