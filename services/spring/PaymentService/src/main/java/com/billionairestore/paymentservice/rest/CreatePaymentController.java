package com.billionairestore.paymentservice.rest;

import com.billionairestore.paymentservice.command.commands.CreatePaymentCommand;
import com.billionairestore.paymentservice.rest.model.ChargeRequestRestModel;
import com.billionairestore.paymentservice.services.StripeChargeRequestDetails;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import jakarta.annotation.PostConstruct;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/payment")
public class CreatePaymentController {
    @Value("${stripe.api_key}")
    private String stripeApiKey;
    private final CommandGateway commandGateway;

    public CreatePaymentController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
        Stripe.apiKey = stripeApiKey;
    }

    @PostMapping
    public String charge()
            throws StripeException {

        StripeChargeRequestDetails stripeChargeRequest = StripeChargeRequestDetails.builder()
                .stripeEmail("test@gmail.com")
                .stripeToken("tok_visa")
                .amount(300).currency(StripeChargeRequestDetails.Currency.THB).build();
        Integer a = commandGateway.sendAndWait(new CreatePaymentCommand("test", stripeChargeRequest));


//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }

}
