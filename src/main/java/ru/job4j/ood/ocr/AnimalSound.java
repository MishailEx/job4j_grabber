package ru.job4j.ood.ocr;

import java.util.List;

public class AnimalSound {
    public void sound(List<Animal> list) {
        for (Animal animal: list) {
            if (animal.getName().equals("bear")) {
                System.out.println("rrr");
            }
            if (animal.getName().equals("cat")) {
                System.out.println("mau");
            }
        }
    }
}


