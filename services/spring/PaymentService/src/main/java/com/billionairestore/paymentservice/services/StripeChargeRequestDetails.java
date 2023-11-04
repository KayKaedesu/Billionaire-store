package com.billionairestore.paymentservice.services;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StripeChargeRequestDetails {

    public enum Currency {
        THB;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;
}