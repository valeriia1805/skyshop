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
        int total = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
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
