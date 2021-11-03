package ru.job4j.ood.srt;

import java.io.Reader;
import java.util.List;

public interface FileToApp<T, E> {
    Reader read(T path);
    List<E> toList(Reader reader);
}
