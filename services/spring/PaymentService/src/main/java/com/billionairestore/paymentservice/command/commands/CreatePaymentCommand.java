package com.billionairestore.paymentservice.command.commands;


import com.billionairestore.paymentservice.services.StripeChargeRequestDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
public class CreatePaymentCommand {
    @TargetAggregateIdentifier
    private String paymentId;
    private StripeChargeRequestDetails stripeChargeRequest;
}
