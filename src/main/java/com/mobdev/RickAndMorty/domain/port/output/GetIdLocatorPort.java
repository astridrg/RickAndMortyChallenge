package com.mobdev.RickAndMorty.domain.port.output;

import com.mobdev.RickAndMorty.domain.model.Origin;

import java.util.Optional;

public interface GetIdLocatorPort {
    public Optional<Origin> getLocationUrl(String url);

    }
