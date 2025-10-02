package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "%s: Фиксированная цена %d".formatted(getName(), getPrice());
    }
}
