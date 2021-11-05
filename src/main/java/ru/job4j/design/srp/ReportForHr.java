package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHr implements Report {
    private Store store;
    private Comparator<Employee> comparator;

    public ReportForHr(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        List<Employee> sortList = store.findBy(filter);
        sortList.sort(comparator);
        for (Employee emp : sortList) {
            text.append(emp.getName()).append(";")
                    .append(emp.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
