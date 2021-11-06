package ru.job4j.ood.lsp;

public class Area {

    public static double getArea(Figure f) {
        return f.getA() * f.getB();
    }

    public static void main(String[] args) {
        Figure figure = new Figure();
        figure.setA(5);
        figure.setB(7);
        System.out.println(getArea(figure));
    }
}
