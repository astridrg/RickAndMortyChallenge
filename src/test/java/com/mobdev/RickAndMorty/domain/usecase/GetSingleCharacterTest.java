package com.mobdev.RickAndMorty.domain.usecase;

import com.mobdev.RickAndMorty.domain.exeption.CharacterNotFoundException;
import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.port.output.GetIdCharacterPort;
import com.mobdev.RickAndMorty.domain.port.output.GetIdLocatorPort;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GetSingleCharacterTest {

    @Mock
    private GetIdCharacterPort getIdCharacterPort;
    @Mock
    private GetIdLocatorPort getIdLocatorPort;

    private GetSingleCharacter getSingleCharacter;

    @BeforeEach
    public void init(){
        getSingleCharacter=new GetSingleCharacter(getIdCharacterPort, getIdLocatorPort);
    }

    @Test
    public void getCharacterTest() {
        Mockito.when(getIdCharacterPort.getCharacterById(1)).thenReturn(Optional.of(MockCharacters.character()));
        Mockito.when(getIdLocatorPort.getLocationUrl("https://rickandmortyapi.com/api/location/1")).thenReturn(Optional.of(MockCharacters.origin()));
        Character characterResult=getSingleCharacter.getCharacter(1);
        Assertions.assertEquals(characterResult.getName() , MockCharacters.character().getName());
    }

    @Test
    public void setGetSingleCharacterWhenIdNotExist() {
        Mockito.when(getIdCharacterPort.getCharacterById(-1)).thenReturn(Optional.empty());
        Assertions.assertThrowsExactly(CharacterNotFoundException.class , () -> getSingleCharacter.getCharacter(-1));

    }

    @Test
    public void setGetSingleCharacterWhenIdNotExist2() {
        Mockito.when(getIdCharacterPort.getCharacterById(0)).thenReturn(Optional.empty());
        Assertions.assertThrowsExactly(CharacterNotFoundException.class , () -> getSingleCharacter.getCharacter(0));

    }




}
