package com.pinheiro.pedidoja.consumer;

import com.pinheiro.pedidoja.model.Order;
import com.pinheiro.pedidoja.model.OrderStatus;
import com.pinheiro.pedidoja.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {
    private final OrderRepository repository;

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void handleOrder(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        repository.save(order);
        System.out.println("Pedido salvo: " + order.getId());
    }
}