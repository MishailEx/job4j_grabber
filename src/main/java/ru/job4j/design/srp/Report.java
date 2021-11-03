package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
    String generateMutable(Predicate<Employee> filter, Comparator<Employee> comparator);
}