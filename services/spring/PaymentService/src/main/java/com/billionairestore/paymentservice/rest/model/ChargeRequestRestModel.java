package com.billionairestore.paymentservice.rest.model;

import com.billionairestore.paymentservice.services.StripeChargeRequestDetails;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChargeRequestRestModel {
    public enum Currency {
        THB;
    }
    private String description;
    private int amount;
    private StripeChargeRequestDetails.Currency currency;
    private String stripeEmail;
    private String stripeToken;
}
