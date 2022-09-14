package com.vladyslavmelnikov.mychat.rabbittest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RabbitMQController {
    Logger logger = LoggerFactory.getLogger(RabbitMQController.class);

    private final AmqpTemplate template;

    @Autowired
    public RabbitMQController(AmqpTemplate template){
        this.template=template;
    }

    @PostMapping("/emit")
    public ResponseEntity<String> entity(@RequestBody String message){
        logger.info("myQueue is");
        for (int i=0;i<10;i++){
            template.convertAndSend("myQueue", ThreadLocalRandom.current().nextInt());
        }
        return ResponseEntity.ok("Your Succes");
    }
}
