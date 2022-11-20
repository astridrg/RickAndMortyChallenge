package com.mobdev.RickAndMorty.externalService.mapperInterface;

import com.mobdev.RickAndMorty.externalService.model.LocationExternalService;
import com.mobdev.RickAndMorty.domain.model.Origin;

public interface LocationMapperInterface {

    public Origin changeToOrigin(LocationExternalService locationModel);
}
