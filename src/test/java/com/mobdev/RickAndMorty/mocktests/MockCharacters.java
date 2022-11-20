package com.mobdev.RickAndMorty.mocktests;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.model.Origin;
import com.mobdev.RickAndMorty.externalService.model.CharacterExternalService;
import com.mobdev.RickAndMorty.externalService.model.LocationExternalService;

public class MockCharacters {


    public static Character character(){
        Character character= new Character();
        character.setId(1);
        character.setName("Rick Sanchez");
        character.setStatus("alive");
        character.setSpecies("Human");
        character.setType("");
        character.setEpisode_count(51);
        character.setOrigin(origin());
        return character;

    }

    public static Origin origin(){
        Origin origin=new Origin();
        origin.setName("Earth (C-137)");
        origin.setUrl("https://rickandmortyapi.com/api/location/1");
        origin.setDimension("Dimension C-137");
        String residents[] = { "https://rickandmortyapi.com/api/character/38",
                "https://rickandmortyapi.com/api/character/45",
                "https://rickandmortyapi.com/api/character/71",
                "https://rickandmortyapi.com/api/character/82",
                "https://rickandmortyapi.com/api/character/83",
                "https://rickandmortyapi.com/api/character/92",
                "https://rickandmortyapi.com/api/character/112",
                "https://rickandmortyapi.com/api/character/114",
                "https://rickandmortyapi.com/api/character/116",
                "https://rickandmortyapi.com/api/character/117",
                "https://rickandmortyapi.com/api/character/120",
                "https://rickandmortyapi.com/api/character/127",
                "https://rickandmortyapi.com/api/character/155",
                "https://rickandmortyapi.com/api/character/169",
                "https://rickandmortyapi.com/api/character/175",
                "https://rickandmortyapi.com/api/character/179",
                "https://rickandmortyapi.com/api/character/186",
                "https://rickandmortyapi.com/api/character/201",
                "https://rickandmortyapi.com/api/character/216",
                "https://rickandmortyapi.com/api/character/239",
                "https://rickandmortyapi.com/api/character/271",
                "https://rickandmortyapi.com/api/character/302",
                "https://rickandmortyapi.com/api/character/303",
                "https://rickandmortyapi.com/api/character/338",
                "https://rickandmortyapi.com/api/character/343",
                "https://rickandmortyapi.com/api/character/356",
                "https://rickandmortyapi.com/api/character/394"};
        origin.setResidents(residents);
        return origin;
    }

    public static CharacterExternalService characterGateway(){
        CharacterExternalService characterGateway=new CharacterExternalService();
        characterGateway.setId(1);
        characterGateway.setName("Rick Sanchez");
        characterGateway.setStatus("Alive");
        characterGateway.setSpecies("Human");
        characterGateway.setType("");
        characterGateway.setGender("male");
        String episode[] = {"https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2"};
        characterGateway.setEpisode(episode);
        characterGateway.setOrigin(origin());
        return characterGateway;
    }

    public static LocationExternalService locationGateway(){
        LocationExternalService locationGateway= new LocationExternalService();
        locationGateway.setName("Citadel of ricks");
        locationGateway.setUrl("https://rickandmortyapi.com/api/location/3");
        locationGateway.setDimension("unknown");
        String residents[] = { "https://rickandmortyapi.com/api/character/38",
                "https://rickandmortyapi.com/api/character/45",
                "https://rickandmortyapi.com/api/character/71",
                "https://rickandmortyapi.com/api/character/82",
                "https://rickandmortyapi.com/api/character/83"};
        locationGateway.setResidents(residents);
        return locationGateway;
    }



}
