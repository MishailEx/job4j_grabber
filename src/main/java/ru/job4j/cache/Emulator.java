package ru.job4j.cache;

public class Emulator {
    private AbstractCache<String, String> abstractCache;
    private String directory;

    public boolean addCash(String name) {
        boolean check = false;
        String value = abstractCache.load(name);
        if (value != null) {
            abstractCache.put(name, value);
            check = true;
        }
        return check;
    }

    public String outCash(String name) {
        return abstractCache.get(name);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setAbstractCache(AbstractCache<String, String> abstractCache) {
        this.abstractCache = abstractCache;
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.setDirectory("C:\\projects\\ooo");
        emulator.setAbstractCache(new DirFileCache(emulator.getDirectory()));
        System.out.println(emulator.addCash("eee.txt"));
        System.out.println(emulator.outCash("rrr.txt"));
        System.out.println(emulator.outCash("eee.txt"));

    }
}
