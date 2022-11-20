package com.mobdev.RickAndMorty.externalService.mapper;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CharacterExternalServiceToCharacterTest {

    private CharacterExternalServiceToCharacter characterGatewayToCharacter;

    @BeforeEach
    public void init(){
        characterGatewayToCharacter=new CharacterExternalServiceToCharacter();
    }

    @Test
    public void changeCharacterTest(){
        Character changeCharacter= characterGatewayToCharacter.changeCharacter(MockCharacters.characterGateway());
        Assertions.assertEquals(MockCharacters.characterGateway().getName(),changeCharacter.getName());


    }

}
