package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5]; // фиксированный размер корзины
        this.size = 0;
    }

    // Добавление продукта
    public void addProduct(Product product) {
        if (size >= products.length) {
            System.err.println("Невозможно добавить продукт: корзина заполнена");
            return;
        }
        products[size] = product;
        size++;
    }

    // Общая стоимость корзины
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    // Печать содержимого
    public void printBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
            if (products[i].isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Проверка наличия товара по имени
    public boolean containsProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Очистка корзины
    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
