package com.mobdev.RickAndMorty.externalService;
import com.mobdev.RickAndMorty.domain.exeption.ExternalException;
import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.port.output.GetIdCharacterPort;
import com.mobdev.RickAndMorty.externalService.mapperInterface.CharacterMapperInterface;
import com.mobdev.RickAndMorty.externalService.model.CharacterExternalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
public class GetByIdCharacterExternalService implements GetIdCharacterPort {


    private String endPointCharacter;
    private CharacterMapperInterface characterMapperInterfaz;
    private RestTemplate restTemplate;

    public GetByIdCharacterExternalService(@Value("${rickandmorty.service.endpoints.character}") String endPointCharacter, CharacterMapperInterface characterMapperInterfaz, RestTemplate restTemplate) {
        this.endPointCharacter = endPointCharacter;
        this.characterMapperInterfaz = characterMapperInterfaz;
        this.restTemplate = restTemplate;
    }

    public Optional <Character> getCharacterById(int id) {
        ResponseEntity<CharacterExternalService> response;
        try {
             response = restTemplate.getForEntity(endPointCharacter + id, CharacterExternalService.class);
        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new ExternalException();
        }

        return Optional.of(characterMapperInterfaz.changeCharacter(response.getBody()));

    }
}
