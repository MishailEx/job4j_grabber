package ru.job4j.design.isp;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MenuClass implements Menu {
    private final Map<String, Button> menu = new LinkedHashMap<>();
    private int num = 1;

    private Button getButton(String name) {
        Predicate<Button> getBut = s -> s.getName().equals(name);
        return searchBut(menu, getBut);
    }

    @Override
    public String allMenu() throws ParseException {
        Map<String, Button> allList = new LinkedHashMap<>();
        for (Map.Entry<String, Button> s : menu.entrySet()) {
            allList.putAll(search(menu, new LinkedHashMap<>(), em -> true));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Button> but : allList.entrySet()) {
            stringBuilder.append(but.getValue().dash())
                    .append(but.getKey()).append(" ")
                    .append(but.getValue().getNum())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private Button searchBut(Map<String, Button> mapSearch, Predicate<Button> predicate) {
        Button button = null;
        for (Map.Entry<String, Button> but : mapSearch.entrySet()) {
            if (predicate.test(but.getValue())) {
                button = but.getValue();
                break;
            }
            if (!but.getValue().getMap().isEmpty()) {
                button = searchBut(but.getValue().getMap(), predicate);
            }
        }
        return button;
    }

    private Map<String, Button> search(Map<String, Button> map, Map<String, Button> mapSearch,
                                       Predicate<Button> predicate) {
        for (Map.Entry<String, Button> but : map.entrySet()) {
            if (predicate.test(but.getValue())) {
                mapSearch.put(but.getKey(), but.getValue());
            }
            if (!but.getValue().getMap().isEmpty()) {
                search(but.getValue().getMap(), mapSearch, predicate);
            }

        }
        return mapSearch;
    }

    @Override
    public void addChild(String parentName, String childName, Action action) throws Exception {
        Button button = getButton(parentName);
        if (button == null) {
            throw new Exception("Элемент не найден");
        }
        Button buttonChild = new Button(childName, action);
        buttonChild.setNum(button.getNum() + "." + button.getSubNumber());
        button.setSubNumber(button.getSubNumber() + 1);
        button.getChild().put(childName, buttonChild);
    }

    @Override
    public void addParent(String parentName, Action action) {
        Button button = getButton(parentName);
        if (button == null) {
            button = new Button(parentName, action);
            menu.put(parentName, button);
            button.setNum(num + "");
            num++;
        }
    }

    @Override
    public Action select(String itemName) {
        Button button = getButton(itemName);
        return button != null ? button.getAction() : null;
    }
}
