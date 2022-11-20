package com.mobdev.RickAndMorty.externalService.getExternalService;

import com.mobdev.RickAndMorty.domain.model.Origin;
import com.mobdev.RickAndMorty.externalService.GetByIdLocatorExternalService;
import com.mobdev.RickAndMorty.externalService.mapperInterface.LocationMapperInterface;
import com.mobdev.RickAndMorty.externalService.model.LocationExternalService;
import com.mobdev.RickAndMorty.mocktests.MockCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class GetByIdLocatorExternalServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private LocationMapperInterface locationMapperInterfaz;

    private GetByIdLocatorExternalService getByIdLocatorGateway;

    @BeforeEach
    public void init() {
        getByIdLocatorGateway= new GetByIdLocatorExternalService(restTemplate, locationMapperInterfaz);
    }

    @Test
    public void getLocationUrlTest(){
        Mockito.when(restTemplate.getForEntity("test", LocationExternalService.class)).thenReturn(ResponseEntity.ok(MockCharacters.locationGateway()));
        Mockito.when(locationMapperInterfaz.changeToOrigin(any())).thenReturn(MockCharacters.origin());
        Optional<Origin> origin= getByIdLocatorGateway.getLocationUrl("test");
        Assertions.assertNotNull(origin);
        Assertions.assertEquals(MockCharacters.origin().getUrl(), origin.get().getUrl());
    }
}

