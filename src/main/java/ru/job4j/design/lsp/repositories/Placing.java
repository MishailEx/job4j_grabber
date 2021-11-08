package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

import java.util.List;


public interface Placing {
    boolean add(Food food);

    boolean test(Food food);

    List<Food> list();
}
