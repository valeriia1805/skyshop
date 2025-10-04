package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.domain.Searchable;
import org.skypro.skyshop.engine.SearchEngine;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("apple", 100);
        Product orange = new SimpleProduct("orange", 200);
        Product pineapple = new SimpleProduct("pineapple", 300);
        Product pineapple2 = new SimpleProduct("pineapple", 300);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(orange);
        basket.addProduct(pineapple);
        basket.addProduct(pineapple2);

        System.out.println(basket.removeProduct("pineapple"));

        basket.printBasket();

        List<Product> removedProducts = basket.removeProduct("pineapple");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }

        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(orange);
        searchEngine.add(pineapple);
        searchEngine.add(pineapple2);
        Article article1 = new Article("About orange", "The best food is orange");
        Article article2 = new Article("About pineapple", "The best food is pineapple");
        searchEngine.add(article1);
        searchEngine.add(article2);

        List<Searchable> matches = searchEngine.search("pineapple");
        System.out.println(matches);
    }
}
