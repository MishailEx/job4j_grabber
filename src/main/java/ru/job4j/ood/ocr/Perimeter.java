package ru.job4j.ood.ocr;

import java.util.List;

public class Perimeter {
    public void example(List<Object> list) {
        for (Object figure: list) {
            if (figure instanceof Square) {
               perimeterSquare((Square) figure);
            }
            if (figure instanceof Circle) {
                perimeterCircle((Circle) figure);
            }
        }
    }
    public void perimeterSquare(Square square) {

    }
    public void perimeterCircle(Circle circle) {
    }
}
