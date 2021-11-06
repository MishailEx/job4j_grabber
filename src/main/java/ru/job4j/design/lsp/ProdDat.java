package ru.job4j.design.lsp;

import ru.job4j.design.lsp.food.Food;

import java.time.LocalDate;

public class ProdDat {
    public static int remainingShelfLife(Food food) {
        return (int) ((LocalDate.now().toEpochDay()
                - food.getCreateDate().toEpochDay()));
    }

    public static int shelfLife(Food food) {
        return (int) ((food.getExpiryDate().toEpochDay()
                - food.getCreateDate().toEpochDay()));
    }

    public static boolean trash(Food food) {
        return LocalDate.now().toEpochDay() > food.getExpiryDate().toEpochDay();
    }
}
