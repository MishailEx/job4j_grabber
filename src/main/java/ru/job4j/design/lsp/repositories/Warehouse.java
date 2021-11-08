package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Placing {
    private List<Food> warehouse;
    private Date date;

    public Warehouse(List<Food> warehouse, Date date) {
        this.warehouse = warehouse;
        this.date = date;
    }


    public List<Food> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Food> warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (test(food)) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean test(Food food) {
        return date.remainingShelfLife(food)
                < date.shelfLife(food) * 0.25 && !date.trash(food);
    }

    @Override
    public List<Food> list() {
        return new ArrayList<>(warehouse);
    }
}
