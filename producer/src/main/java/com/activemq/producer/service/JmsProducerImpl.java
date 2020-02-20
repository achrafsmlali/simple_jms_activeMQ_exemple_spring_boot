package com.activemq.producer.service;

import com.activemq.producer.configuration.JmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class JmsProducerImpl implements JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    private static final Logger log = LoggerFactory.getLogger(JmsProducerImpl.class);

    @Override
    public void sendMessage(String message) {
        log.info("Sending << " + message + ">> to the queue");

        jmsTemplate.send(JmsConfig.queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });

        log.info("Message << " + message + ">> successfully sent ");
    }
}
