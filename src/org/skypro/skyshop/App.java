package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        // Создаем продукты
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 200);
        Product juice = new Product("Сок", 120);
        Product chocolate = new Product("Шоколад", 150);

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(juice);

        // Попытка добавить продукт в переполненную корзину
        basket.addProduct(chocolate);

        // Печать содержимого корзины
        basket.printBasket();

        // Общая стоимость
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара в корзине
        System.out.println("Есть ли молоко в корзине? " + basket.containsProduct("Молоко"));
        System.out.println("Есть ли вода в корзине? " + basket.containsProduct("Вода"));

        // Очистка корзины
        basket.clearBasket();

        // Проверка после очистки
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());
        System.out.println("Есть ли хлеб в корзине? " + basket.containsProduct("Хлеб"));
    }
}
