package com.activemq.producer.controller;

import com.activemq.producer.service.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProducerController {

    @Autowired
    JmsProducer jmsProducer;

    @GetMapping("/{message}")
    public void send(@PathVariable String message) {
        jmsProducer.sendMessage(message);
    }

}
