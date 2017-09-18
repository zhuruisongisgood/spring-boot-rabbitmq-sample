package com.daishumovie.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuruisong on 2017/9/15
 * @since 1.0
 */
@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }

//    private final AmqpAdmin amqpAdmin;
//    private final AmqpTemplate amqpTemplate;
//
//    private final RabbitAdmin rabbitAdmin;
//    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public AmqpApplication(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate,RabbitTemplate rabbitTemplate,RabbitAdmin rabbitAdmin) {
//        this.amqpAdmin = amqpAdmin;
//        this.amqpTemplate = amqpTemplate;
//        this.rabbitAdmin = rabbitAdmin;
//        this.rabbitTemplate = rabbitTemplate;


        Queue queue = QueueBuilder.durable("my-queue-1").build();
        Exchange exchange = ExchangeBuilder.directExchange("my-exchange-1").build();
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("my-routing-1").noargs();
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(binding);

    }






}
