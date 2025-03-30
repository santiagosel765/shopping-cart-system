package com.shopping.common.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private Double total;
    private List<OrderItemDto> items;
}