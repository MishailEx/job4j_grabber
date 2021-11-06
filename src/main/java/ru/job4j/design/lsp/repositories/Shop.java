package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.ProdDat;
import ru.job4j.design.lsp.food.Food;
import java.util.List;

public class Shop implements Placing {
    private List<Food> shop;
    private double discount;

    public Shop(List<Food> shop, double discount) {
        this.shop = shop;
        this.discount = discount;
    }

    public List<Food> getShop() {
        return shop;
    }

    public void setShop(List<Food> shop) {
        this.shop = shop;
    }


    @Override
    public void add(Food food) {
        shop.add(food);
    }

    @Override
    public boolean test(Food food) {
        boolean chek = false;
        if (ProdDat.remainingShelfLife(food)
                > ProdDat.shelfLife(food) * 0.75 && !ProdDat.trash(food)) {
            shop.add(food);
            chek = true;
        }
        if (ProdDat.remainingShelfLife(food)
                > ProdDat.shelfLife(food) * 0.25 && ProdDat.remainingShelfLife(food)
                < ProdDat.shelfLife(food) * 0.75 && !ProdDat.trash(food)) {
            food.setPrice(food.getPrice() * discount);
            shop.add(food);
            chek = true;
        }
        return chek;
    }

    @Override
    public List<Food> list() {
        return shop;
    }
}
