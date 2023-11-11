package com.billionairestore.shelfservice.query;

import com.billionairestore.shelfservice.core.data.ShelfEntity;
import com.billionairestore.shelfservice.core.data.ShelfRepository;
import com.billionairestore.shelfservice.query.rest.ShelfRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShelfQueryHandler {
    private final ShelfRepository shelfRepository;
    public ShelfQueryHandler(ShelfRepository shelfRepository){
        this.shelfRepository = shelfRepository;
    }
    @QueryHandler
    public List<ShelfRestModel> findShelf(FindShelfQuery query){
        List<ShelfRestModel> shelfsRest = new ArrayList<>();
        List<ShelfEntity> storedShelfs = shelfRepository.findAll();
        for (ShelfEntity shelfEntity: storedShelfs){
            ShelfRestModel shelfRestModel = new ShelfRestModel();
            BeanUtils.copyProperties(shelfEntity, shelfRestModel);
            shelfsRest.add(shelfRestModel);
        }
        return shelfsRest;
    }
}
