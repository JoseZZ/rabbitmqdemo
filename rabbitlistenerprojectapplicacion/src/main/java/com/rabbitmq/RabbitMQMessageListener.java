package com.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by Jose Gonzalez on 23/11/2018.
 */
public class RabbitMQMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("mensaje = [" + new String(message.getBody()) + "]");
    }
}
