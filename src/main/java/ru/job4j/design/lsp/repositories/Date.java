package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

public interface Date {
    int remainingShelfLife(Food food);
    int shelfLife(Food food);
    boolean trash(Food food);
}
