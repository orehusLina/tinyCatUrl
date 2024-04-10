package org.example;

import org.example.controller.UrlController;
import org.example.controller.dto.UrlDto;
import org.example.exception.EntityNotFoundException;
import org.example.repository.UrlRepositoryImpl;
import org.example.service.GetShortUrl;
import org.example.service.UrlServiceImpl;
import org.example.utils.ReadUtils;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        while (true) {
            UrlController urlController = new UrlController(new UrlServiceImpl(new UrlRepositoryImpl()));
            printMenu();
            String chosenService = ReadUtils.readLine();

            assert chosenService != null;
            if (chosenService.equals("1")) {
                System.out.println("Введите исходную ссылку");
                String longUrl = "";
                String shortUrl = "";
                while (true) {
                    assert longUrl != null;
                    if (!longUrl.isEmpty()) break;
                    longUrl = readAndValidateUrl();
                }
                GetShortUrl ggetShortUrl = new GetShortUrl();
                shortUrl = ggetShortUrl.getShortUrl(longUrl);
                String id = urlController.addUrl(new UrlDto(longUrl, shortUrl));
                System.out.printf("Создана ссылка с токеном %s%n", shortUrl);

            } else if (chosenService.equals("2")) {
                System.out.println("Введите короткую ссылку:");
                String id = ReadUtils.readLine();
                try {
                    UrlDto urlDto = urlController.getUrl(id); // поменять поиск по айди на поиск по строке
                    System.out.printf("Найдена ссылка \n С идентификатором %s \n Длинная ссылка %s\n Короткая ссылка %s\n%n",
                            urlDto.id(), urlDto.longUrl(), urlDto.shortUrl());
                } catch (EntityNotFoundException ex) {
                    System.out.printf("Ссылка с идентификатором %s не найден%n", id);
                }
            } else if (chosenService.equals("3")) {
                return;
            } else {
                System.out.println("Выберите валидный вариант");
            }
        }
    }

    private static String readAndValidateUrl() {
        try {
            String urlString = ReadUtils.readLine();
            if (urlString == null || urlString.isBlank()) {
                System.out.println("Ссылка некорректна");
                return null;
            }
            return urlString;
        } catch (Exception ex) {
            System.out.println("Хз надо нормальный вид ошибки добавить");
        }
        return null;
    }

    private static void printMenu() {
        System.out.println("""
                Приложения для работы с ссылками
                                
                Выберите действие:
                                
                1. Создать ссылку
                2. Выдать исходную ссылку по токену
                3. Выйти
                                
                """);
    }


}