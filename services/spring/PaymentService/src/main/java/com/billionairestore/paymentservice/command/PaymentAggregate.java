package com.billionairestore.paymentservice.command;

import com.billionairestore.paymentservice.command.commands.CreatePaymentCommand;
import com.billionairestore.paymentservice.core.events.PaymentCreatedEvent;
import com.billionairestore.paymentservice.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class PaymentAggregate {

    private final StripeService stripeService;
    @Autowired
    public PaymentAggregate(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @EventSourcingHandler
    public void on(PaymentCreatedEvent event) {

    }

    @EventHandler
    public void on(CreatePaymentCommand command) throws StripeException {
        Charge a = stripeService.charge(command.getStripeChargeRequest());
        System.out.println("ASJDOIADSJoi");
    }


}
