package org.example.controller.dto;

public record UrlDto(String id, String longUrl, String shortUrl) {

    public UrlDto(String longUrl, String shortUrl) {
        this(null, longUrl, shortUrl);
    }
}
