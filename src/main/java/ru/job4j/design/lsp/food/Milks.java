package ru.job4j.design.lsp.food;

import java.time.LocalDate;

public class Milks extends Food {
    public Milks(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
