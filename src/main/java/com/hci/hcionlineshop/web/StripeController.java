package com.hci.hcionlineshop.web;

import com.google.gson.Gson;
import com.hci.hcionlineshop.dto.CreatePayment;
import com.hci.hcionlineshop.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpResponse;


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
    public String CreateCheckoutSession() throws StripeException {
        SessionCreateParams params =
                SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/" + "?success=true")
                .setCancelUrl("http://localhost:3000/" + "?canceled=true")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(1L)
                                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                .setPrice("price_1NOSqzF4xvj0hs3UVK757YAo")
                                .build())
                .build();
        Session session = Session.create(params);
        return gson.toJson(session.getUrl());

    }




}
