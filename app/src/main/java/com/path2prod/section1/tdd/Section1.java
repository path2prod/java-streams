package com.path2prod.section1.tdd;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Section1 {

    public static Stream<Integer> challenge1() {
        Stream<Integer> numbers = IntStream.rangeClosed(1,10 ).boxed();
        return null;    }

    public static List<String> challenge2() {
        return List.of("first", "second", "third", "fourth", "fifth").stream().toList();
    }

    public static Integer challenge3() {
       Stream<Integer> numbers = IntStream.rangeClosed(1,10 ).boxed();
       return null;
    }

    public static Integer challenge4() {
        Stream<Integer> numbers = IntStream.rangeClosed(1,10 ).boxed();
        return null;    }

    public static boolean challenge5() {
        List<String> words =  List.of("first", "second", "third", "fourth", "fifth");
        return false;
    }


    public static boolean challenge6() {
        List<String> words = List.of("first", "second", "apple", "fourth", "fifth");
        return false;
    }

}
