package com.daishumovie.amqp;

import com.daishumovie.bean.MsgBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhuruisong on 2017/9/15
 * @since 1.0
 */
@Component
public class Customer {

    @RabbitListener(queues = {"my-queue-1"})
    public void xiaofei1(String content){
        System.out.println("消费1：我收到了你的信息："+content);
    }

    @RabbitListener(queues = {"my-queue-1"})
    public void xiaofei2(String content){
        System.out.println("消费2：我收到了你的信息："+content);
    }

    @RabbitListener(queues = {"my-queue-1"})
    public void xiaofei3(String content){
        System.out.println("消费3：我收到了你的信息："+content);
    }


    //消费实体
    @RabbitListener(queues = {"my-queue-2"})
    public void xiaofei01(MsgBean content){
        System.out.println("消费01-1：我收到了你的信息："+content);
    }



}
