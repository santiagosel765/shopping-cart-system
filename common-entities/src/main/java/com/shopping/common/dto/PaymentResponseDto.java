package com.shopping.common.dto;

import com.shopping.common.enums.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDto {
    private Long paymentId;
    private PaymentStatus status;
    private LocalDateTime timestamp;
}