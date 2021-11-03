package ru.job4j.design.srp;

public interface OutToFile<T, P> {
    boolean convertReport(T text, P convertText);
}
