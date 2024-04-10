package org.example.service;

import org.example.exception.EntityNotFoundException;
import org.example.repository.UrlRepository;
import org.example.repository.dao.UrlDao;
import org.example.service.model.Url;

import java.util.Optional;

public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public String addUrl(Url url) {
        UrlDao urlDao = new UrlDao(url.LongUrl(), url.ShortUrl());
        return urlRepository.save(urlDao);
    }

    @Override
    public Url findUrl(String id) throws EntityNotFoundException {
        Optional<UrlDao> catDao = urlRepository.findUrlByShortUrl(id);
        return catDao.map(cat -> new Url(cat.id(), cat.longUrl(), cat.shortUrl())).orElseThrow(() -> new EntityNotFoundException("юрлшечка не найдена"));
    }
}
