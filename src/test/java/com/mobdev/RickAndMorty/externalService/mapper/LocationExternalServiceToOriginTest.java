package com.mobdev.RickAndMorty.externalService.mapper;


import com.mobdev.RickAndMorty.domain.model.Origin;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LocationExternalServiceToOriginTest {

    private LocationExternalServiceToOrigin locationGatewayToOrigin;

    @BeforeEach
    public void init(){
        locationGatewayToOrigin=new LocationExternalServiceToOrigin();
    }

    @Test
    public void changeLocationTest(){
        Origin origin=locationGatewayToOrigin.changeToOrigin(MockCharacters.locationGateway());
        Assertions.assertEquals(MockCharacters.locationGateway().getName(), origin.getName() );
    }

}
