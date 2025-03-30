package com.shopping.payment.controller;

import com.shopping.common.dto.PaymentRequestDto;
import com.shopping.common.dto.PaymentResponseDto;
import com.shopping.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<PaymentResponseDto> getStatus(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentStatus(orderId));
    }

}
