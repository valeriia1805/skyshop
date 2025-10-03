package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.domain.Searchable;
import org.skypro.skyshop.engine.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создаем продукты
        try {
            new SimpleProduct("Яблоко", -10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new DiscountedProduct("Хлеб", 40, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 40, 20);
        Product milk = new SimpleProduct("Молоко", 80);
        Product cheese = new FixPriceProduct("Сыр");
        Product juice = new SimpleProduct("Сок", 120);
        Product chocolate = new SimpleProduct("Шоколад", 150);

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(cheese);
        searchEngine.add(juice);
        searchEngine.add(chocolate);

        Article article1 = new Article("Золотое яблоко", "text1");
        Article article2 = new Article("title2", "text2");
        Article article3 = new Article("title3", "Это текст содержит слово яблоко и яблоко в нём два раза");
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        try {
            Searchable result = searchEngine.searchMostRelevant("яблоко");
            System.out.println(result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable result = searchEngine.searchMostRelevant("снигерс");
            System.out.println(result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }
}
