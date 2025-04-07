package com.path2prod.section5.complete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Section5 {

    public static int challenge1(){
       return Integer.sum(Collections.nCopies(1_000_000_000, 2).parallelStream().reduce(0,Integer::sum), 5);
    }

    public static long challenge2(){
        return IntStream.rangeClosed(2, 2_000_000)
                            .parallel()
                            .filter(Section5::isPrime)
                            .count();
    }


    public static long challenge3() throws IOException{
        try (Stream<String> lines = Files.lines(Path.of("src/main/java/com/path2prod/resources/ramdon_text.txt").toAbsolutePath()).parallel()) {
            return lines
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .filter(word -> word.equalsIgnoreCase("lorem"))
                .count();
        }
    }


    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        
        int sqrt = (int) Math.sqrt(n) + 1;
        return IntStream.rangeClosed(3, sqrt)
                      .filter(x -> x % 2 != 0)
                      .noneMatch(x -> n % x == 0);
    }

}
