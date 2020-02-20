package com.activemq.consumer.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private static final Logger log = LoggerFactory.getLogger(ConsumerListener.class);

    @JmsListener(destination =  "${activemq.queue-name}")
    public void consume(String message){
                log.info("message >> " + message + " << sent successfully");
    }
}
