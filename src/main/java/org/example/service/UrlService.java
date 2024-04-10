package org.example.service;

import org.example.exception.EntityNotFoundException;
import org.example.service.model.Url;

public interface UrlService {

    /**
     * save new cat or update existing cat
     *
     * @param url - model with cat parameters
     * @return - id of saved cat
     */
    String addUrl(Url url);

    /**
     * find exist cat by provided id
     *
     * @param id - of cat to look for
     * @return {@link Url} by id
     * @throws EntityNotFoundException - if cat with provided id not found
     */
    Url findUrl(String id) throws EntityNotFoundException;
}
