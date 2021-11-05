package ru.job4j.ood.srt;

import java.util.List;

public class Cats implements FeedAnimal<Cats> {
    String name;

    public Cats(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Cats> listAnimals() {
        return  List.of(new Cats("tiger"), new Cats("cat"));
    }

    @Override
    public void feed(List<Cats> animal) {
        for (Cats s: animal) {
            System.out.println(s.name + " eat fish");
        }
    }
}
