package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("C:\\projects\\ooo");
        System.out.println(dirFileCache.load("rrr.txt"));
    }
}
