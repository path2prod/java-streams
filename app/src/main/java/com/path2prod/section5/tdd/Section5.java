package com.path2prod.section5.tdd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Section5 {

    public static int challenge1(){
       Collections.nCopies(1_000_000_000, 2);
       return 0;
    }

    public static long challenge2(){
       IntStream.rangeClosed(2, 2_000_000);
        return 0L;
    }


    public static long challenge3() throws IOException{
        Files.lines(Path.of("src/main/java/com/path2prod/resources/ramdon_text.txt").toAbsolutePath());
        return 0L;
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
