package com.example.notificationsservice.listener;

import com.example.notificationsservice.model.CartEvent;
import com.example.notificationsservice.service.MockSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CartEventListener {
  private final MockSender mockSender;

  public CartEventListener(MockSender mockSender) {
    this.mockSender = mockSender;
  }

  @RabbitListener(queues = "${rabbit.queue.name}")
  public void listen(CartEvent cartEvent) {
    mockSender.send(cartEvent);
  }
}
