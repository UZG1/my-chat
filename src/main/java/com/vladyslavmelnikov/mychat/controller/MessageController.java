package com.vladyslavmelnikov.mychat.controller;




import com.vladyslavmelnikov.mychat.domain.Message;
import com.vladyslavmelnikov.mychat.domain.User;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getContent(@PathVariable Message message){
        if(message.getUser().getLoginStatus()== User.LoginStatus.LOGIN){
            return message;
        }
        else {
            return null;
        }

    }

    @MessageMapping("/login")
    @SendTo("/topic/return-to")
    public void userOfMessage(Message message){
        message.getUser().setLoginStatus(User.LoginStatus.LOGIN);
    }



    

}