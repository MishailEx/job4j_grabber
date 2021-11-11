package ru.job4j.design.isp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseInput implements Pars<List<Integer>, String> {

    @Override
    public List<Integer> pars(String par) {
        List<String> num = Arrays.asList(par.split("\\."));
        return num.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}