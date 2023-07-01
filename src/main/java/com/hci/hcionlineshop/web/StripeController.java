package com.hci.hcionlineshop.web;

import com.google.gson.Gson;
import com.hci.hcionlineshop.dto.CreatePayment;
import com.hci.hcionlineshop.dto.CreatePaymentResponse;
import com.hci.hcionlineshop.dto.ProductDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*")
public class StripeController {

    private static Gson gson = new Gson();

    @PostMapping("/create-payment-intent")
    public String CreatePaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(15 * 100L)
                        .setCurrency("aed")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);
        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(intent.getClientSecret());
        return gson.toJson(paymentResponse);
    }
    @PostMapping("/create-checkout-session")
    public String CreateCheckoutSession(@RequestBody List<ProductDto> products) throws StripeException {

        List<SessionCreateParams.LineItem> listLineItem = products.stream().map(productDto -> SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                .setPrice("price_1NOSqzF4xvj0hs3UVK757YAo")
                .build()).toList();

        SessionCreateParams params =
                SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/" + "?success=true")
                .setCancelUrl("http://localhost:3000/" + "?canceled=true")
                .addAllLineItem(listLineItem)
                .build();
        Session session = Session.create(params);
        return gson.toJson(session.getUrl());
    }




}
