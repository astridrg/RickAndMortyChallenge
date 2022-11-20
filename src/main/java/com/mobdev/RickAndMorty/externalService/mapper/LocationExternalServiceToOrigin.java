package com.mobdev.RickAndMorty.externalService.mapper;

import com.mobdev.RickAndMorty.externalService.mapperInterface.LocationMapperInterface;
import com.mobdev.RickAndMorty.externalService.model.LocationExternalService;
import com.mobdev.RickAndMorty.domain.model.Origin;
import org.springframework.stereotype.Component;

@Component
public class LocationExternalServiceToOrigin implements LocationMapperInterface {

    public Origin changeToOrigin(LocationExternalService locationExternalService){
        Origin origin=new Origin();
        origin.setName(locationExternalService.getName());
        origin.setUrl(locationExternalService.getUrl());
        origin.setDimension(locationExternalService.getDimension());
        origin.setResidents(locationExternalService.getResidents());
        return origin;
    }
}
