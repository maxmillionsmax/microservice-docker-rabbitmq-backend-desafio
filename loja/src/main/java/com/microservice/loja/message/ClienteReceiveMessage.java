package com.microservice.loja.message;

import com.microservice.loja.dto.ProdutoOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteReceiveMessage {

    @RabbitListener(queues = {"${produto.rabbitmq.queu}"})
    public void receiveMessage(@Payload ProdutoOrderDto produtoOrderDto){
        System.out.println(produtoOrderDto.getClass());
        System.out.println(produtoOrderDto);

    }
}
