package com.mobdev.RickAndMorty.configspring;

import com.mobdev.RickAndMorty.domain.port.input.GetSingleCharacterPort;
import com.mobdev.RickAndMorty.domain.port.output.GetIdCharacterPort;
import com.mobdev.RickAndMorty.domain.port.output.GetIdLocatorPort;
import com.mobdev.RickAndMorty.domain.usecase.GetSingleCharacter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBeans {

    @Bean
    public GetSingleCharacterPort characterPort(GetIdCharacterPort getIdCharacterPort, GetIdLocatorPort getIdLocatorPort){
        return new GetSingleCharacter(getIdCharacterPort, getIdLocatorPort);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
