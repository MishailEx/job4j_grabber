package ru.job4j.design.srp;

public interface Convert<E, F> {
    void conversion(E employee, F field);
}
