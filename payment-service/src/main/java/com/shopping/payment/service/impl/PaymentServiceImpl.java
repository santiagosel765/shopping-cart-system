package com.shopping.payment.service.impl;


import com.shopping.common.dto.PaymentRequestDto;
import com.shopping.common.dto.PaymentResponseDto;
import com.shopping.common.enums.PaymentStatus;
import com.shopping.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Map<Long, PaymentResponseDto> paymentStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public PaymentResponseDto processPayment(PaymentRequestDto request) {
        PaymentResponseDto response = PaymentResponseDto.builder()
                .paymentId(idGenerator.getAndIncrement())
                .status(PaymentStatus.COMPLETED)
                .timestamp(LocalDateTime.now())
                .build();

        paymentStore.put(request.getOrderId(), response);
        return response;
    }

    @Override
    public PaymentResponseDto getPaymentStatus(Long orderId) {
        return paymentStore.getOrDefault(orderId,
                PaymentResponseDto.builder()
                        .paymentId(-1L)
                        .status(PaymentStatus.PENDING)
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
