package com.pinheiro.pedidoja.dto;

import com.pinheiro.pedidoja.model.OrderStatus;

import java.time.LocalDateTime;

public record OrderResponse(
        Long orderId,
        String productName,
        Integer quantity,
        OrderStatus status,
        LocalDateTime createdAt
) {}