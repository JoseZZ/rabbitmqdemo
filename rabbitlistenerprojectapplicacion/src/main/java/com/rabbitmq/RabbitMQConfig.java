package com.rabbitmq;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String MY_QUEUE = "MyQueue";

    // Creamos un bean para el queue, aunque podriamos usar la anotacion @Queue para crear el queue
    @Bean
    Queue myQueue(){
        // Creamos un queue y lo hacemos durable
        return new Queue(MY_QUEUE, true);
    }

    @Bean
    Exchange myExchange(){
        return ExchangeBuilder.topicExchange("MyTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding binding(){
        //return new Binding(MY_QUEUE,Binding.DestinationType.QUEUE, "MyTopicExchange", "topic", null);
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with("topic")
                .noargs();
    }

    @Bean
    Queue secondQueue(){
        // Podemos crear un queue con el builder
        return QueueBuilder.durable("Ejemplo2ndQueue")
                .autoDelete()
                .exclusive()
                .build();
    }

    // Creamos un bean para la conexion con el broker
    @Bean
    ConnectionFactory connectionFactory(){
        // Para no tener que abrir y cerrar la conexion la hacemos caching
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    // Creamos el message listener para esperar los mensajes del queue
    @Bean
    MessageListenerContainer messageListenerContainer (){
        SimpleMessageListenerContainer simpleMessageListenerContainer =
                new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
        return simpleMessageListenerContainer;
    }
}
