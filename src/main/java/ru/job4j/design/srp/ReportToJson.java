package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee e = new Employee("dd", now, now, 200);
        store.add(e);
        List<Employee> list = new ArrayList<Employee>();
        list.add(e);
//        ReportToJson report = new ReportToJson(store);
//        String s = report.generate(em -> true);
//        System.out.println(s);
        Gson gson = new GsonBuilder().create();
        String sd = "sddfsdf, sdfdsf, sfdf";
        System.out.println(gson.toJson(list));


    }
}
