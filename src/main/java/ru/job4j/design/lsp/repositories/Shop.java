package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Placing {
    private List<Food> shop;
    private double discount;
    private Date date;

    public Shop(List<Food> shop, double discount, Date date) {
        this.shop = shop;
        this.discount = discount;
        this.date = date;
    }

    public List<Food> getShop() {
        return shop;
    }

    public void setShop(List<Food> shop) {
        this.shop = shop;
    }


    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (test(food)) {
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean test(Food food) {
        boolean chek = false;
        if (date.remainingShelfLife(food)
                > date.shelfLife(food) * 0.75 && !date.trash(food)) {
            chek = true;
        }
        if (date.remainingShelfLife(food)
                > date.shelfLife(food) * 0.25 && date.remainingShelfLife(food)
                < date.shelfLife(food) * 0.75 && !date.trash(food)) {
            food.setPrice(food.getPrice() * discount);
            chek = true;
        }
        return chek;
    }

    @Override
    public List<Food> list() {
        return new ArrayList<>(shop);
    }
}
