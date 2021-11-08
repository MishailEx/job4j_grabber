package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.Comparator;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        String rsl = "<html>" + System.lineSeparator() + "<head>"
                + System.lineSeparator() + "<title>"
                + System.lineSeparator() + "Список сотрудников для IT"
                + System.lineSeparator() + "</title>"
                + System.lineSeparator() + "</head>"
                + System.lineSeparator() + "<body>"
                + System.lineSeparator() + "Name; Hired; Fired; Salary;"
                + System.lineSeparator() + worker.getName() + ";" + worker.getHired()
                + ";" + worker.getFired() + ";" + worker.getSalary() + ";" + System.lineSeparator()
                + "</body>" + System.lineSeparator() + "</html>";
                ReportForIt report = new ReportForIt(store);
        assertThat(report.generate(em -> true), is(rsl));
    }

    @Test
    public void whenSalaryAnotherGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForBuh(store, 80);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append((worker.getSalary() * 80)).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenComparatorAndDeleteTwoFields() throws JAXBException {
        Comparator<Employee> comparator = (o1, o2) -> (int) (o2.getSalary() - o1.getSalary());
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new ReportForHr(store, comparator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate((em -> true)), is(expect.toString()));
    }
}