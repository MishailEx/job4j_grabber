package ru.job4j.design.isp;

import java.text.ParseException;

public interface Menu {
    void addChild(String parentName, String childName, Action action) throws Exception;
    void addParent(String parentName, Action action);
    Action select(String itemName);
    String allMenu() throws ParseException;
}
