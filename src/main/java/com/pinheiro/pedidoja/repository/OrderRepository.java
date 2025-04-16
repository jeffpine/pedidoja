package com.pinheiro.pedidoja.repository;

import com.pinheiro.pedidoja.model.Order;
import com.pinheiro.pedidoja.model.OrderStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Consulta derivada automática
    List<Order> findByStatus(OrderStatus status);

    // Consulta com @Query personalizada
    @Query("SELECT o FROM Order o WHERE o.createdAt >= :startDate AND o.createdAt < :endDate")
    List<Order> findOrdersBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    // Atualização em massa otimizada
    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.status = :newStatus WHERE o.status = :oldStatus")
    int updateOrderStatus(OrderStatus oldStatus, OrderStatus newStatus);

    // Consulta nativa SQL
    @Query(value = "SELECT * FROM orders WHERE quantity > :minQuantity", nativeQuery = true)
    List<Order> findOrdersWithMinQuantity(int minQuantity);
}
