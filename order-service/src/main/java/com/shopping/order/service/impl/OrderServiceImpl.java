package com.shopping.order.service.impl;

import com.shopping.common.dto.OrderRequestDto;
import com.shopping.common.dto.OrderResponseDto;
import com.shopping.common.dto.OrderItemDto;
import com.shopping.common.entity.order.Order;
import com.shopping.common.entity.order.OrderDetail;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto request) {
        Order order = Order.builder()
                .userId(request.getUserId())
                .orderDate(LocalDateTime.now())
                .total(request.getItems().stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum())
                .build();

        order = orderRepository.save(order);

        Order finalOrder = order;
        List<OrderDetail> details = request.getItems().stream().map(item ->
                OrderDetail.builder()
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .price(item.getPrice())
                        .order(finalOrder)
                        .build()
        ).collect(Collectors.toList());

        order.setOrderDetails(details);
        order = orderRepository.save(order);

        return OrderResponseDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderDate(order.getOrderDate())
                .total(order.getTotal())
                .items(request.getItems())
                .build();
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        return orderRepository.findById(id).map(order ->
                OrderResponseDto.builder()
                        .id(order.getId())
                        .userId(order.getUserId())
                        .orderDate(order.getOrderDate())
                        .total(order.getTotal())
                        .items(order.getOrderDetails().stream().map(detail ->
                                new OrderItemDto(detail.getProductId(), detail.getQuantity(), detail.getPrice())
                        ).collect(Collectors.toList()))
                        .build()
        ).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream().map(order ->
                OrderResponseDto.builder()
                        .id(order.getId())
                        .userId(order.getUserId())
                        .orderDate(order.getOrderDate())
                        .total(order.getTotal())
                        .items(order.getOrderDetails().stream().map(detail ->
                                new OrderItemDto(detail.getProductId(), detail.getQuantity(), detail.getPrice())
                        ).collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());
    }
}
