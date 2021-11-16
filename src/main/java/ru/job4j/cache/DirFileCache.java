package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        File file = new File(cachingDir, key);
            String cash = null;
            try {
                if (file.exists() && !file.isDirectory()) {
                    cash = Files.readString(file.toPath(), StandardCharsets.UTF_8);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return cash;
    }


    @Override
    public String get(String key) {
        String res = super.get(key);
        if (res == null) {
            String content = load(key);
            cache.put(key, new SoftReference<>(content));
            res = content;
        }
        return res;
    }
}