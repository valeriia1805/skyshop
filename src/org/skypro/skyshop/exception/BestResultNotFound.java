package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String query) {
        super("Для запроса [%s] не нашлось подходящих совпадений.".formatted(query));
    }
}
