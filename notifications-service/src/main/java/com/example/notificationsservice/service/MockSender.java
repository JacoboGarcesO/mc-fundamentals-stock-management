package com.example.notificationsservice.service;

import com.example.notificationsservice.model.CartEvent;
import org.springframework.stereotype.Service;

@Service
public class MockSender {
  public void send(CartEvent cartEvent) {
    System.out.println("Sending mock notification" + cartEvent.getUserEmail() + " productos: " + cartEvent.getProducts().size());
  }
}
