package org.example.service.model;

public record Url(String id, String LongUrl, String ShortUrl) {
    public Url(String LongUrl, String ShortUrl) {
        this(null, LongUrl, ShortUrl);
    }
}
