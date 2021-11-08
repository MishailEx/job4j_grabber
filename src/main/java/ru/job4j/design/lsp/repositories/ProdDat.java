package ru.job4j.design.lsp.repositories;

import ru.job4j.design.lsp.food.Food;

import java.time.LocalDate;

public class ProdDat implements Date {
    @Override
    public int remainingShelfLife(Food food) {
        return (int) ((LocalDate.now().toEpochDay()
                - food.getCreateDate().toEpochDay()));
    }
    @Override
    public int shelfLife(Food food) {
        return (int) ((food.getExpiryDate().toEpochDay()
                - food.getCreateDate().toEpochDay()));
    }
    @Override
    public boolean trash(Food food) {
        return LocalDate.now().toEpochDay() > food.getExpiryDate().toEpochDay();
    }
}
