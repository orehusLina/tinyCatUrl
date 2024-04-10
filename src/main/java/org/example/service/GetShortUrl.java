package org.example.service;
import org.example.service.UrlHashCreator;

import java.security.NoSuchAlgorithmException;

public class GetShortUrl {
    private UrlHashCreator urlHashCreator = new UrlHashCreator();
    public String getShortUrl(String longUrl) throws NoSuchAlgorithmException {

        String shortUrl = urlHashCreator.createSHAHash(longUrl);
        shortUrl = shortUrl.substring(0, 8);
        return shortUrl;
    }
}
