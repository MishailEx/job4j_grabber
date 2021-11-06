package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.ProdDat;
import ru.job4j.design.lsp.food.Food;
import java.util.List;

public class Trash implements Placing {
    private List<Food> trash;


    public Trash(List<Food> trash) {
        this.trash = trash;

    }


    public List<Food> getTrash() {
        return trash;
    }

    public void setTrash(List<Food> trash) {
        this.trash = trash;
    }

    @Override
    public void add(Food food) {
        trash.add(food);
    }

    @Override
    public boolean test(Food food) {
        boolean chek = false;
        if (ProdDat.trash(food)) {
            trash.add(food);
            chek = true;
        }
        return chek;
    }

    @Override
    public List<Food> list() {
        return trash;
    }
}
