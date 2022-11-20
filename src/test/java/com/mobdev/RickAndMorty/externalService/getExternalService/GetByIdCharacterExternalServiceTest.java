package com.mobdev.RickAndMorty.externalService.getExternalService;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.externalService.GetByIdCharacterExternalService;
import com.mobdev.RickAndMorty.externalService.mapperInterface.CharacterMapperInterface;
import com.mobdev.RickAndMorty.externalService.model.CharacterExternalService;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class GetByIdCharacterExternalServiceTest {

    @Mock
    private CharacterMapperInterface characterMapperInterfaz;
    @Mock
    private RestTemplate restTemplate;

     private String endPointCharacter = "www.test.com";

    private GetByIdCharacterExternalService characterGateway;
    @BeforeEach
    public void init() {
        characterGateway= new GetByIdCharacterExternalService(endPointCharacter, characterMapperInterfaz, restTemplate);
    }
    @Test
    public void getCharacterById(){
        Mockito.when(restTemplate.getForEntity(endPointCharacter + 1 , CharacterExternalService.class)).thenReturn(ResponseEntity.ok(MockCharacters.characterGateway()));
        Mockito.when(characterMapperInterfaz.changeCharacter(any())).thenReturn(MockCharacters.character());
        Optional<Character> character= characterGateway.getCharacterById(1);
        Assertions.assertEquals(character.get().getName(), MockCharacters.character().getName());

    }


}
