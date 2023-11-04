package com.billionairestore.paymentservice.core.events;

import com.billionairestore.paymentservice.services.StripeChargeRequestDetails;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCreatedEvent {


    private String paymentId;
    private StripeChargeRequestDetails stripeChargeRequest;
}
