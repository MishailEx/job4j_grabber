package ru.job4j.ood.srt;

import java.util.List;

public interface FeedCat<T> {
    List<T> createAllCats();
    void feed(List<T> cats);
}
