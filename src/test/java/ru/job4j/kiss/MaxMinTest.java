package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;


public class MaxMinTest {

    @Test
    public void max() {
        Comparator<Integer> comparator = Comparator.reverseOrder();
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(7);
        list.add(2);
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.max(list, comparator);
        assertThat(rsl, is(9));
    }

    @Test
    public void min() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(7);
        list.add(2);
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.max(list, comparator);
        assertThat(rsl, is(2));
    }
}