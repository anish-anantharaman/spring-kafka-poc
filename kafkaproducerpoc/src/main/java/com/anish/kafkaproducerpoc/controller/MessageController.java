package com.anish.kafkaproducerpoc.controller;

import com.anish.kafkaproducerpoc.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class MessageController {

    private final MessageService messageService;

    @PostMapping(path = "/messages",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sendMessage(@RequestBody Object message) {
        messageService.sendMessage(message);
        return ResponseEntity.accepted().body("Success");
    }
}
