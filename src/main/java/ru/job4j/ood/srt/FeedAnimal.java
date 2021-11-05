package ru.job4j.ood.srt;

import java.util.List;

public interface FeedAnimal<T> {
    List<T> listAnimals();
    void feed(List<T> animals);
}
