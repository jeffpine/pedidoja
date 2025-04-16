package com.pinheiro.pedidoja.service;

import com.pinheiro.pedidoja.dto.OrderRequest;
import com.pinheiro.pedidoja.dto.OrderResponse;
import com.pinheiro.pedidoja.model.Order;
import com.pinheiro.pedidoja.model.OrderStatus;
import com.pinheiro.pedidoja.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();
        order.setProductName(request.productName());
        order.setQuantity(request.quantity());
        order.setStatus(OrderStatus.PROCESSING);

        Order savedOrder = repository.save(order);
        kafkaTemplate.send("orders", savedOrder);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getStatus(),
                savedOrder.getCreatedAt()
        );
    }
}