package com.mobdev.RickAndMorty.controller;

import com.mobdev.RickAndMorty.domain.model.Character;
import com.mobdev.RickAndMorty.domain.port.input.GetSingleCharacterPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterAndLocationController {

    private GetSingleCharacterPort getSingleCharacterPort;


    public CharacterAndLocationController(GetSingleCharacterPort getSingleCharacterPort) {
        this.getSingleCharacterPort = getSingleCharacterPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getByIdCharacter(@PathVariable int id) {
        Character response = getSingleCharacterPort.getCharacter(id);
        return ResponseEntity.ok(response);
    }
}
