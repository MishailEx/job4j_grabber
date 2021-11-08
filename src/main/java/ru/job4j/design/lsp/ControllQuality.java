package ru.job4j.design.lsp;

import ru.job4j.design.lsp.food.Bread;
import ru.job4j.design.lsp.repositories.*;
import ru.job4j.design.lsp.food.Food;
import ru.job4j.design.lsp.food.Milks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    public void distribution(Food food, List<Placing> list) {
        for (Placing placing : list) {
            placing.add(food);
        }
    }

    public static void main(String[] args) {
        Food food = new Bread("bread", LocalDate.of(2021, 12, 6),
                LocalDate.of(2021, 10, 6), 200, 0.25);
        Food food2 = new Milks("milk", LocalDate.of(2021, 10, 6),
                LocalDate.of(2021, 9, 6), 200, 0.25);

        Date date = new ProdDat();
        Placing shop = new Shop(new ArrayList<>(), 0.25, date);
        Placing warehouse = new Warehouse(new ArrayList<>(), date);
        Placing trash = new Trash(new ArrayList<>(), date);
        List<Placing> p = List.of(shop, warehouse, trash);
        ControllQuality controllQuality = new ControllQuality();
        controllQuality.distribution(food, p);
        controllQuality.distribution(food2, p);
        shop.list().forEach(System.out::println);
    }
}
