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
        String id = urlDao.id();
        getInstance().urlMap.put(id, urlDao);
        return id;
    }

    public UrlDao getUrl(String id) {
        return getInstance().urlMap.get(id);
    }
}
