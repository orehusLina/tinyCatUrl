package org.example.repository;

import org.example.repository.dao.UrlDao;

import java.util.Optional;

public interface UrlRepository {

    Optional<UrlDao> findUrlByShortUrl(String shortUrl);

    String save(UrlDao urlDao);
}
