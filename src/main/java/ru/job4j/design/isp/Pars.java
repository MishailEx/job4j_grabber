package ru.job4j.design.isp;

import java.text.ParseException;

public interface Pars<T, S> {
    T pars(S par) throws ParseException;
}