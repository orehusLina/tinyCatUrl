package org.example.service;

import org.example.exception.EntityNotFoundException;
import org.example.repository.UrlRepositoryImpl;
import org.example.service.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlServiceTest {

    private final UrlService urlService = new UrlServiceImpl(new UrlRepositoryImpl());

    @Test
    void testAddCat() throws EntityNotFoundException {
        //given:
        Url url = new Url("codeforces.com/hashtables", "");
        //when:
        String id = urlService.addUrl(url);
        Url savedUrl = urlService.findUrl(id);
        //then:
        assertEquals(url.LongUrl(), savedUrl.LongUrl());
        assertEquals(url.ShortUrl(), savedUrl.ShortUrl());
    }
}
