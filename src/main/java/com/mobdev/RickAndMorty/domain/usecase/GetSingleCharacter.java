package com.mobdev.RickAndMorty.domain.usecase;


import com.mobdev.RickAndMorty.domain.exeption.CharacterNotFoundException;
import com.mobdev.RickAndMorty.domain.exeption.LocationNotFoundException;
import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.model.Origin;
import com.mobdev.RickAndMorty.domain.port.output.GetIdCharacterPort;
import com.mobdev.RickAndMorty.domain.port.input.GetSingleCharacterPort;
import com.mobdev.RickAndMorty.domain.port.output.GetIdLocatorPort;
;

import java.util.Optional;


public class GetSingleCharacter implements GetSingleCharacterPort {

    private GetIdCharacterPort idCharacterGateway;
    private GetIdLocatorPort idLocatorGateway;

    public GetSingleCharacter(GetIdCharacterPort idCharacterGateway, GetIdLocatorPort idLocatorGateway) {
        this.idCharacterGateway = idCharacterGateway;
        this.idLocatorGateway = idLocatorGateway;
    }


    public Character getCharacter(int id){
        Optional<Character> character = idCharacterGateway.getCharacterById(id);
        if (character.isEmpty()) {
            throw new CharacterNotFoundException();
        }
        Character characterResp= character.get();
        if (character.get().getOrigin().getUrl().isEmpty()){
            return character.get();

        }else {
            characterResp.setOrigin(getLocationByUrl(character.get().getOrigin().getUrl()));
            return characterResp;
        }

    }

    private Origin getLocationByUrl(String url){
        Optional<Origin> getOrigin= idLocatorGateway.getLocationUrl(url);
        if (getOrigin.isEmpty()){
            throw new LocationNotFoundException();
        }
        return getOrigin.get();
    }

}
