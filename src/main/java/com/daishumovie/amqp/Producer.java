package com.daishumovie.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuruisong on 2017/9/15
 * @since 1.0
 */
@RequestMapping
@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send(@RequestParam String msg){
        rabbitTemplate.convertAndSend("my-exchange-1","my-routing-1",msg);
        return "已发送："+msg;
    }
}
