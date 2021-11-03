package ru.job4j.design.srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertReport implements OutToFile<String, File> {

    @Override
    public boolean convertReport(String text, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
           fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
