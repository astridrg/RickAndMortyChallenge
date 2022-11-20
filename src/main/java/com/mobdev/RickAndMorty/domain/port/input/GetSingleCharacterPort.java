package com.mobdev.RickAndMorty.domain.port.input;

import com.mobdev.RickAndMorty.domain.model.Character;

public interface GetSingleCharacterPort {
    public Character getCharacter(int id);
}
