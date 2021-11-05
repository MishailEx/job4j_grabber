package ru.job4j.ood.srt;

import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

public interface FileToFile<R, T, E> {
    List<E> readFile(T path);
    boolean toList(R writer);
}
