package com.shopping.order.service;

import com.shopping.common.dto.OrderResponseDto;
import com.shopping.common.dto.OrderRequestDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto request);
    OrderResponseDto getOrderById(Long id);
    List<OrderResponseDto> getAllOrders();
}