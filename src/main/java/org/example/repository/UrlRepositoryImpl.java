package org.example.repository;

import org.example.database.Database;
import org.example.repository.dao.UrlDao;

import java.util.Optional;
import java.util.UUID;

public class UrlRepositoryImpl implements UrlRepository {

    private static final Database dataBase = Database.getInstance();

    public Optional<UrlDao> findUrlByShortUrl(String shortUrl) {
        return Optional.ofNullable(dataBase.getUrl(shortUrl));
    }

    @Override
    public String save(UrlDao urlDao) {
        String urlDaoId = urlDao.id();
        if (urlDaoId != null) {
            dataBase.saveUrl(urlDao);
            return urlDaoId;
        }

        String id = UUID.randomUUID().toString();
        dataBase.saveUrl(new UrlDao(id, urlDao.longUrl(), urlDao.shortUrl()));
        return id;
    }
}
