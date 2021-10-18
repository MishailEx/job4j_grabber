package ru.job4j.quartz;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PlusTest {

    @Test
    public void test() {
        Plus name = new Plus();
        int c = name.plus(4, 6);
        assertThat(c, is(10));
    }

}