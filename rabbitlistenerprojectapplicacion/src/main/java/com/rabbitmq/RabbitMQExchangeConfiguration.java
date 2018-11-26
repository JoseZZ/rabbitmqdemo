package com.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.ExchangeBuilder.directExchange;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exampleExchange(){
        return new TopicExchange("ExampleExchange");
    }

    // Podemos crear un exchange tambien con builder
    @Bean
    Exchange example2ndExchange(){
        return ExchangeBuilder.directExchange("Example2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newExchange(){
        return ExchangeBuilder.topicExchange("TopicExchangeTEst")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange("FanoutExchaneTest")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange headersExchange(){
        return ExchangeBuilder.headersExchange("HeadersExchangeTest")
                .internal()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }

}
