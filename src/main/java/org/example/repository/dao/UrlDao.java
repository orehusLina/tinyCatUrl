package org.example.repository.dao;

public record UrlDao(String id, String longUrl, String shortUrl) {

    public UrlDao(String LongUrl, String ShortUrl) {
        this(null, LongUrl, ShortUrl);
    }
}
