package com.mobdev.RickAndMorty.domain.exeption;

public class LocationNotFoundException extends RuntimeException{

    public LocationNotFoundException() {

        super("Not found location");
    }
}
