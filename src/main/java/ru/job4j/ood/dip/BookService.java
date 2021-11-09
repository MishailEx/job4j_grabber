package ru.job4j.ood.dip;

public class BookService {
    private BokkDB bokkDB;

    public BookService(BokkDB bokkDB) {
        this.bokkDB = bokkDB;
    }
}
