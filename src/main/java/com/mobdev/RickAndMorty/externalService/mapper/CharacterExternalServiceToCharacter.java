package com.mobdev.RickAndMorty.externalService.mapper;

import com.mobdev.RickAndMorty.externalService.mapperInterface.CharacterMapperInterface;
import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.externalService.model.CharacterExternalService;
import org.springframework.stereotype.Component;

@Component
public class CharacterExternalServiceToCharacter implements CharacterMapperInterface {



    public Character changeCharacter(CharacterExternalService characterExternalService){
        Character character=new Character();
        character.setId(characterExternalService.getId());
        character.setName(characterExternalService.getName());
        character.setStatus(characterExternalService.getStatus());
        character.setSpecies(characterExternalService.getSpecies());
        character.setType(characterExternalService.getType());
        character.setEpisode_count(characterExternalService.getEpisode().length);
        character.setOrigin(characterExternalService.getOrigin());
        return character;
    }

}
