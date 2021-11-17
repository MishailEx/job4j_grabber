package ru.job4j.design.isp;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Button implements MenuItem {
    private final Map<String, Button> child = new LinkedHashMap<>();
    private String name;
    private Action action;
    private int subNumber = 1;
    private String num;

    public Button(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String dash() throws ParseException {
        StringBuilder str = new StringBuilder();
        Pars<List<Integer>, String> parseInput = new ParseInput();
        List<Integer> list = parseInput.pars(num);
        str.append("---".repeat(Math.max(0, list.size() - 1)));
        return str.toString();
    }

    public Map<String, Button> getChild() {
        return child;
    }

    @Override
    public void setAction(Action action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public int getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(int subNumber) {
        this.subNumber = subNumber;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Map<String, Button> getMap() {
        return child;
    }
}
