package ru.job4j.design.srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class ReportForIt implements Report {
    private Store store;

    public ReportForIt(Store store) {
        this.store = store;
    }

    public boolean convertReport(String text, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator()).append("<title>")
                .append(System.lineSeparator()).append("Список сотрудников для IT")
                .append(System.lineSeparator()).append("</title>")
                .append(System.lineSeparator()).append("</head>")
                .append(System.lineSeparator()).append("<body>")
                .append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>").append(System.lineSeparator()).append("</html>");
        return text.toString();
    }
}
