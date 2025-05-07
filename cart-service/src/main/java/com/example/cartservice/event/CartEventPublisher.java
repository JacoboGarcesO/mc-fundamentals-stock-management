package com.example.cartservice.event;

import com.example.cartservice.dto.CartDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CartEventPublisher {
  private final RabbitTemplate template;

  @Value("${rabbit.queue.name}")
  private String queueName;

  @Value("${rabbit.exchange.name}")
  private String exchangeName;

  @Value("${rabbit.routing.key}")
  private String routingKey;

  public CartEventPublisher(RabbitTemplate template) {
    this.template = template;
  }

  public void publishPurchaseMadeEvent(CartDTO cart) {
    template.convertAndSend(exchangeName, routingKey, cart);
    System.out.println("Published cart event");
  }
}
