package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Placing {
    private List<Food> trash;
    private Date date;


    public Trash(List<Food> trash, Date date) {
        this.trash = trash;
        this.date = date;
    }

    public List<Food> getTrash() {
        return trash;
    }

    public void setTrash(List<Food> trash) {
        this.trash = trash;
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (test(food)) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean test(Food food) {
        return date.trash(food);
    }

    @Override
    public List<Food> list() {
        return new ArrayList<>(trash);
    }
}
