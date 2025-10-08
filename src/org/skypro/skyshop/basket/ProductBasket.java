package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new TreeMap<>();
    }

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), _ -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        return productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        long specialCount = getSpecialCount();
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    private long getSpecialCount() {
        return productsMap.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public List<Product> removeProduct(String name) {
        if (!productsMap.containsKey(name)) {
            return Collections.emptyList();
        }
        return productsMap.remove(name);
    }
}
