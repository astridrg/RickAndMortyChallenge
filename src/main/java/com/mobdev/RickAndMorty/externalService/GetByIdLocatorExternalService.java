package com.mobdev.RickAndMorty.externalService;

import com.mobdev.RickAndMorty.domain.exeption.ExternalException;
import com.mobdev.RickAndMorty.domain.model.Origin;
import com.mobdev.RickAndMorty.domain.port.output.GetIdLocatorPort;
import com.mobdev.RickAndMorty.externalService.mapperInterface.LocationMapperInterface;
import com.mobdev.RickAndMorty.externalService.model.LocationExternalService;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
public class GetByIdLocatorExternalService implements GetIdLocatorPort {

    private final RestTemplate restTemplate;
    private LocationMapperInterface locationMapperInterfaz;

    public GetByIdLocatorExternalService(RestTemplate restTemplate,
                                         LocationMapperInterface locationMapperInterfaz) {
        this.restTemplate = restTemplate;
        this.locationMapperInterfaz=locationMapperInterfaz;
    }


    public Optional<Origin> getLocationUrl(String url){
        ResponseEntity<LocationExternalService>  response;
        try {
            response = restTemplate.getForEntity( url, LocationExternalService.class);

        }catch (HttpClientErrorException.NotFound e){
            return Optional.empty();
        } catch (Exception e) {
            throw new ExternalException();
        }
        return Optional.ofNullable(locationMapperInterfaz.changeToOrigin(response.getBody()));
    }
}
