package com.mobdev.RickAndMorty.externalService.mapperInterface;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.externalService.model.CharacterExternalService;


public interface CharacterMapperInterface {

    public Character changeCharacter(CharacterExternalService characterGateway);

}
