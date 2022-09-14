package com.vladyslavmelnikov.mychat.rabbittest.config;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitListenerAnnot {

    @RabbitListener(queues = "myQueue")
    public void thisQueueListener(String Message){

    }
}
