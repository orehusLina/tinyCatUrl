package org.example.repository;

import org.example.database.Database;
import org.example.exception.EntityNotFoundException;
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
        try {
            String urlDaoShort = urlDao.shortUrl();
            // if (urlDaoShort != null) {
                dataBase.saveUrl(urlDao);
                return urlDaoShort;
            //}
        }
        catch(Exception ex) {
            System.out.print("Нет короткой ссылки");
            return null;
        }
    }
}
