package com.activemq.consumer.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    public static String queueName;

    public static String url ;

    public JmsConfig (@Value("${activemq.broker-url}") String url, @Value("${activemq.queue-name}") String name){
        JmsConfig.url = url;
        JmsConfig.queueName = name;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(url);
        return connectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }
}
