package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.ProdDat;
import ru.job4j.design.lsp.food.Food;
import java.util.List;

public class Warehouse implements Placing {
    private List<Food> warehouse;

    public Warehouse(List<Food> warehouse) {
        this.warehouse = warehouse;
    }


    public List<Food> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Food> warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void add(Food food) {
        warehouse.add(food);
    }

    @Override
    public boolean test(Food food) {
        boolean chek = false;
        if (ProdDat.remainingShelfLife(food)
                < ProdDat.shelfLife(food) * 0.25 && !ProdDat.trash(food)) {
            warehouse.add(food);
            chek = true;
        }
        return chek;
    }

    @Override
    public List<Food> list() {
        return warehouse;
    }
}
