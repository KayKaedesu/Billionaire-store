package com.billionairestore.importservice.command;

import com.billionairestore.importservice.command.commands.CreateImportCommand;
import com.billionairestore.importservice.command.rest.CreateImportRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/imports")
public class ImportRestController {

    CommandGateway commandGateway;

    @Autowired
    public ImportRestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @PostMapping
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

}
