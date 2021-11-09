package ru.job4j.design.srp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@XmlRootElement(name = "store")
public class MemStore implements Store {

    private List<Employee> employees = new ArrayList<>();
    @XmlElement(name = "employee")
    private List<Employee> filterEmployees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        filterEmployees = employees.stream().filter(filter).collect(Collectors.toList());
        return filterEmployees;
    }
}