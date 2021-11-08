package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportToXml implements Report {
    private Store store;

    public ReportToXml(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringBuilder text = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(store.findBy(filter), writer);
                text.append(writer.getBuffer().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return text.toString();
    }
}
