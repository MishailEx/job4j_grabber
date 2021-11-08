package ru.job4j.design.isp;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu implements Buttons {
    private final Map<Integer, Button> map = new HashMap<>();
    private int num = 1;

    @Override
    public void add(Button button) {
        map.put(num, button);
        button.setNumber(num + "");
        num++;
    }

    public void show(Buttons buttons) throws ParseException {

        for (Map.Entry<Integer, Button> s : buttons.getMap().entrySet()) {
            System.out.println(s.getValue().ret() + s.getValue().getName() + " " + s.getValue().getNumber());
            if (!s.getValue().getMap().isEmpty()) {
                show(s.getValue());
            }
        }
    }

    public Button getBut(String number) throws ParseException {
        Pars<List<Integer>, String> parseInput = new ParseInput();
        List<Integer> list = parseInput.pars(number);
        Button button = null;
        if (list != null) {
            button = map.get(list.get(0));
            if (list.size() != 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    int n = list.get(i);
                    button = button.getMap().get(n);
                }
            }
        }
        return button;
    }

    @Override
    public Map<Integer, Button> getMap() {
        return map;
    }
}
