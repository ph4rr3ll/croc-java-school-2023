package ru.croc.java.lesson4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class TextStat {

    public Map<String, Integer> countWords(String text) {
        List<String> words = Arrays.asList(text.split(" "));
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (!result.containsKey(word)) {
                result.put(word, 0);
            }
            result.put(word, result.get(word) + 1);
        }
        return result;
    }
}
