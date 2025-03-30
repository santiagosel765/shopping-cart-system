package com.shopping.order.repository;

import com.shopping.common.entity.order.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = "orderDetails")
    Optional<Order> findById(Long id);

    @EntityGraph(attributePaths = "orderDetails")
    List<Order> findAll();
}
