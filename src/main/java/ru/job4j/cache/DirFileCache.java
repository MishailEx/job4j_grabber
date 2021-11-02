package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path link = Path.of(cachingDir, key);
            String cash = null;
            try {
                cash = Files.readString(link, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cache.put(key, new SoftReference<>(cash));
        return get(key);
    }

}