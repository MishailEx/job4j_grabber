package ru.job4j.ood.lsp;

public class Square extends Figure {
    private double a;
    private double b;

    @Override
    public void setA(double a) {
        this.a = a;
        this.b = a;
    }

    @Override
    public void setB(double b) {
        this.a = b;
        this.b = a;
    }
}
