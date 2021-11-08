package ru.job4j.design.isp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParseInput implements Pars<List<Integer>, String> {

    @Override
    public List<Integer> pars(String par) throws ParseException {
        List<Integer> num = new ArrayList<>();
        String[] split = par.split("\\.");
        int addNum;
        for (String s : split) {
            try {
                addNum = Integer.parseInt(s);
                num.add(addNum);
            } catch (Exception e) {
                throw new ParseException("Неправильный ввод", 0);
            }
        }
        return num;
    }
}
