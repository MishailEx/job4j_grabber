package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportToJson implements Report {
    private Store store;

    public ReportToJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        text.append(gson.toJson(store.findBy(filter)));
        return text.toString();
    }
}
