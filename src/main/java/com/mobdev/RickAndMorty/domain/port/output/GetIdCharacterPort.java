package com.mobdev.RickAndMorty.domain.port.output;

import com.mobdev.RickAndMorty.domain.model.Character;

import java.util.Optional;

public interface GetIdCharacterPort {
    public Optional<Character> getCharacterById(int id) ;

    }
