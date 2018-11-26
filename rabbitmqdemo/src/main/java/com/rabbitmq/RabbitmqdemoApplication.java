package com.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqdemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		SimpleMessage mensaje = new SimpleMessage();
		mensaje.setName("PrimerMensaje");
		mensaje.setDescription("Descripcion");

		rabbitTemplate.convertAndSend("TestExchange", "testRouting", mensaje);


	}
}
