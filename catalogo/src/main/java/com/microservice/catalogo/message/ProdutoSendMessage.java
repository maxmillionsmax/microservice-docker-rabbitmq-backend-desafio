package com.microservice.catalogo.message;

import com.microservice.catalogo.dto.ProdutoOrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoSendMessage {

    @Value("${produto.rabbitmq.exchange}")
    private String exchange;

    @Value("${produto.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProdutoSendMessage(RabbitTemplate rabbitTemplate) {
       this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ProdutoOrderDto produtoOrderDto){
        System.out.println(produtoOrderDto);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange,routingkey,produtoOrderDto);
    }
}
