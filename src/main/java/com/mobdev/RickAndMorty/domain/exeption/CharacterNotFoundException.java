package com.mobdev.RickAndMorty.domain.exeption;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException() {

        super("Not found character");
    }
}
