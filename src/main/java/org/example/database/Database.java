package org.example.database;

import org.example.repository.dao.UrlDao;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Database instance;
    private final Map<String, UrlDao> urlMap;

    private Database() {
        urlMap = new HashMap<>();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public String saveUrl(UrlDao urlDao) {
        String shortUrl = urlDao.shortUrl();
        getInstance().urlMap.put(shortUrl, urlDao);
        return shortUrl;
    }

    public UrlDao getUrl(String shortUrl) {
        return getInstance().urlMap.get(shortUrl);
    }
}
