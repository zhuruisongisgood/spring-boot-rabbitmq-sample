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


    @Autowired
    public AmqpApplication(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate,RabbitTemplate rabbitTemplate,RabbitAdmin rabbitAdmin) {


        Queue queue = QueueBuilder.durable("my-queue-1").build();
        Queue queue2 = QueueBuilder.durable("my-queue-2").build();
        Exchange exchange = ExchangeBuilder.directExchange("my-exchange-1").build();
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("my-routing-1").noargs();
        Binding binding2 = BindingBuilder.bind(queue2).to(exchange).with("my-routing-2").noargs();
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareQueue(queue2);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(binding);
        rabbitAdmin.declareBinding(binding2);

    }






}
