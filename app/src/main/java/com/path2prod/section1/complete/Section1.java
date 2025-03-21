package com.path2prod.section1.complete;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Section1 {

    public static Stream<Integer> challenge1() {
        return IntStream.rangeClosed(1, 10).boxed().filter(i -> i % 2 != 0);
    }

    public static List<String> challenge2() {
        return List.of("first", "second", "third", "fourth", "fifth").stream().map(String::toUpperCase).toList();
    }

    public static Integer challenge3() {
       return IntStream.rangeClosed(1,10 ).boxed().reduce((a,b) -> a +b).orElseThrow(() -> new RuntimeException("error on reduce"));
    }

    public static Integer challenge4() {
        return IntStream.rangeClosed(1,10).boxed().max(Integer::compareTo).orElseThrow(() -> new RuntimeException("error on max"));
    }

    public static boolean challenge5() {
        return List.of("first", "second", "third", "fourth", "fifth").stream().noneMatch(word -> word.toLowerCase().contains("a"));
    }


    public static boolean challenge6() {
        return List.of("first", "second", "apple", "fourth", "fifth").stream().anyMatch(word -> word.toLowerCase().contains("a"));
    }

}
