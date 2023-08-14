package com.PaymentSystem.Controller;


import com.razorpay.RazorpayException;
import com.PaymentSystem.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    //http://localhost:8080/payments/create-order?amount=54&currency=INR
    @PostMapping("/create-order")
    public String createOrder(@RequestParam("amount") int amount, @RequestParam("currency") String currency) throws RazorpayException {
        String orderId = paymentService.createOrder(amount, currency);
        return "Order created with ID: " + orderId;
    }

    //http://localhost:8080/payments/verify-signature?orderId=9879878t78&paymentId=54reddcf&signature=RKM
    @PostMapping("/verify-signature")
    public String verifyPaymentSignature(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String signature) throws RazorpayException {
        return paymentService.verifyPaymentSignature(orderId, paymentId, signature);
    }  // Other controller methods for payment callbacks, etc.
}

