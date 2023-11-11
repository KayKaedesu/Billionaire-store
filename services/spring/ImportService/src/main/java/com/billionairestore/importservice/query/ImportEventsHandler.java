package com.billionairestore.importservice.query;

import com.billionairestore.importservice.core.data.ImportEntity;
import com.billionairestore.importservice.core.data.ImportRepository;
import com.billionairestore.importservice.core.events.ImportCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ImportEventsHandler {
    private final ImportRepository importRepository;

    public ImportEventsHandler(ImportRepository importRepository){
        this.importRepository = importRepository;
    }

    @EventHandler
    public void on(ImportCreatedEvent event){
        ImportEntity entity = new ImportEntity();
        BeanUtils.copyProperties(event, entity);
        importRepository.save(entity);

    }
}
