package com.mobdev.RickAndMorty.controller;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.port.input.GetSingleCharacterPort;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CharacterAndLocationControllerTest {

    @Mock
    private GetSingleCharacterPort getSingleCharacterPort;

    private CharacterAndLocationController characterAndLocationController;

    @BeforeEach
    public void init(){
        characterAndLocationController=new CharacterAndLocationController(getSingleCharacterPort);
    }

    @Test
    public void getByIdCharacter(){
        Mockito.when(getSingleCharacterPort.getCharacter(1)).thenReturn(MockCharacters.character());
        ResponseEntity<Character> character = characterAndLocationController.getByIdCharacter(1);
        Assertions.assertEquals(MockCharacters.character().getName(), character.getBody().getName());
    }

}
