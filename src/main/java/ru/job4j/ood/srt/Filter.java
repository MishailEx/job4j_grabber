package ru.job4j.ood.srt;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public interface Filter<T> {
    List<T> readFile(Path path);
    List<T> filter(Predicate predicate, List<T> list);
}
