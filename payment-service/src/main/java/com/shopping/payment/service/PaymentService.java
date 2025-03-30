package com.shopping.payment.service;

import com.shopping.common.dto.PaymentRequestDto;
import com.shopping.common.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto processPayment(PaymentRequestDto request);
    PaymentResponseDto getPaymentStatus(Long orderId);
}