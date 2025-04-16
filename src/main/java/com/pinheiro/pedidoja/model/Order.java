package com.pinheiro.pedidoja.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders") // Opcional se o nome da tabela for diferente
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PROCESSING;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Version // Para controle de concorrência
    private Long version;
}

