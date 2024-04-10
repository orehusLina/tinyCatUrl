package org.example.repository;

import org.example.database.Database;
import org.example.repository.dao.UrlDao;

import java.util.Optional;
import java.util.UUID;

public class UrlRepositoryImpl implements UrlRepository {

    private static final Database dataBase = Database.getInstance();

    @Override
    public Optional<UrlDao> findUrlById(String id) {
        return Optional.ofNullable(dataBase.getUrl(id));
    }

    @Override
    public String save(UrlDao urlDao) {
        String catDaoId = urlDao.id();
        if (catDaoId != null) {
            dataBase.saveUrl(urlDao);
            return catDaoId;
        }

        String id = UUID.randomUUID().toString();
        dataBase.saveUrl(new UrlDao(id, urlDao.longUrl(), urlDao.shortUrl()));
        return id;
    }
}
