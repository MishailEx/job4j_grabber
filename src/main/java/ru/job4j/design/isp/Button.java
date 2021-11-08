package ru.job4j.design.isp;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Button implements Buttons {
    private final Map<Integer, Button> map = new LinkedHashMap<>();
    private final String name;
    private int subNum = 1;
    private String number;

    public Button(String name) {
        this.name = name;
    }

    @Override
    public void add(Button button) {
        map.put(subNum, button);
        button.setNumber(number + "." + subNum);
        subNum++;
    }

    public String ret() throws ParseException {
        StringBuilder str = new StringBuilder();
        Pars<List<Integer>, String> parseInput = new ParseInput();
        List<Integer> list = parseInput.pars(number);
        str.append("---".repeat(Math.max(0, list.size() - 1)));
        return str.toString();
    }

    @Override
    public Map<Integer, Button> getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
