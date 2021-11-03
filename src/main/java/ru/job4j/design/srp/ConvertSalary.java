package ru.job4j.design.srp;

public class ConvertSalary implements Convert<Employee, String> {

    @Override
    public void conversion(Employee employee, String field) {
        double salary = employee.getSalary();
        if (field.equals("dollar")) {
            employee.setSalary(salary * 80);
        }
    }
}
