package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@Ignore
public class GeneratorTest {

    @Test
    public void checkGeneratorThenOk() {
        String template = "I am a ${name}, Who are ${subject}?";
        Generator generator = new GeneratorString();
        Map<String, String> list = new HashMap<>();
        list.put("name", "Ivan");
        list.put("subject", "you");
        String result = generator.produce(template, list);
        String control = "I am a Ivan, Who are you?";
        assertThat(result, is(control));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGeneratorThenExcess() {
        String template = "I am a ${name}, Who are ${subject}, ${!}?";
        Generator generator = new GeneratorString();
        Map<String, String> list = new HashMap<>();
        list.put("name", "Ivan");
        list.put("subject", "you");
        String result = generator.produce(template, list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGeneratorThenMapExcessKey() {
        String template = "I am a ${name}, Who are ${subject}?";
        Generator generator = new GeneratorString();
        Map<String, String> list = new HashMap<>();
        list.put("name", "Ivan");
        list.put("subject", "you");
        list.put("!", "??");
        String result = generator.produce(template, list);
    }
}