package com.mobdev.RickAndMorty.controller;


import com.mobdev.RickAndMorty.domain.exeption.CharacterNotFoundException;
import com.mobdev.RickAndMorty.domain.exeption.ExternalException;
import com.mobdev.RickAndMorty.domain.exeption.LocationNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity handlerCharacterNotFoundException(CharacterNotFoundException e) {
        return ResponseEntity.notFound().build();

    }


    @ExceptionHandler(ExternalException.class)
    public ResponseEntity handlerExternalException(ExternalException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());

    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity LocationNotFoundException(LocationNotFoundException e) {
        return ResponseEntity.notFound().build();

    }
}
