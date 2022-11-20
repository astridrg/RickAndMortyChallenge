package com.mobdev.RickAndMorty.domain.exeption;

public class ExternalException extends RuntimeException{

    public ExternalException() {

        super("there was an error connecting to the rick and morty service");
    }
}
