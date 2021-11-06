package ru.job4j.ood.lsp;

public class Ostrich extends Bird {
    @Override
    public void fly(Bird bird) {
        System.out.println("я не летаю");
    }
}
