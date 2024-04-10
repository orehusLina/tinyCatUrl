package org.example.controller;

import org.example.controller.dto.UrlDto;
import org.example.exception.EntityNotFoundException;
import org.example.service.UrlService;
import org.example.service.model.Url;

public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    public String addUrl(UrlDto urlDto) {
        return urlService.addUrl(new Url(urlDto.longUrl(), urlDto.shortUrl()));
    }

    public UrlDto getUrl(String shortUrl) throws EntityNotFoundException {
        Url url = urlService.findUrl(shortUrl);
        if (url == null) return null;
        return new UrlDto(url.id(), url.LongUrl(), url.ShortUrl());
    }
}
