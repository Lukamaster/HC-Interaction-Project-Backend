package com.hci.hcionlineshop;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HcionlineshopApplication {

    @PostConstruct
    public void setup() {
        Stripe.apiKey = "sk_test_51NOOIfF4xvj0hs3UKGPmklCC0G4RLPrb96xU0c6LtgZE7vGZbtWfVYeJ81RNvzE8FgSNIfajqjRb71Bmj9T4DKNX00PhLsq1fw";
    }

    public static void main(String[] args) {
        SpringApplication.run(HcionlineshopApplication.class, args);
    }

}
