package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String link = cachingDir + "\\" + key;
        if (!cache.containsKey(key)) {
            try (BufferedReader in = new BufferedReader(new FileReader(link, StandardCharsets.UTF_8))) {
                StringBuilder stringBuilder = new StringBuilder();
                in.lines().forEach(e -> stringBuilder.append(e).append(System.lineSeparator()));
                cache.put(key, new SoftReference<>(stringBuilder.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return get(key);
    }

}