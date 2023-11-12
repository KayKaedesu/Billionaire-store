package com.billionairestore.importservice.command;

import com.billionairestore.importservice.command.commands.BuyProductCommand;
import com.billionairestore.importservice.command.commands.CreateImportCommand;
import com.billionairestore.importservice.command.rest.BuyProductRestModel;
import com.billionairestore.importservice.command.rest.CreateImportRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ImportRestController {

    CommandGateway commandGateway;

    @Autowired
    public ImportRestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @RequestMapping(value = "/imports", method = RequestMethod.POST)
    public String createProduct(@RequestBody CreateImportRestModel createImportRestModel) {
        CreateImportCommand command = CreateImportCommand.builder()
                .productId(createImportRestModel.getProductId())
                .name(createImportRestModel.getName())
                .category(createImportRestModel.getCategory())
                .buyPrice(createImportRestModel.getBuyPrice())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        } catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyProduct(@RequestBody BuyProductRestModel buyProductRestModel) {
        BuyProductCommand command = BuyProductCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .logId(buyProductRestModel.getProductId() + buyProductRestModel.getUserId())
                .productId(buyProductRestModel.getProductId())
                .userId(buyProductRestModel.getUserId())
                .name(buyProductRestModel.getName())
                .category(buyProductRestModel.getCategory())
                .buyPrice(buyProductRestModel.getBuyPrice())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        } catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

}
