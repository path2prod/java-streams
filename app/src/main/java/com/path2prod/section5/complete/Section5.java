package com.path2prod.section5.complete;

import java.util.Collections;
import java.util.stream.IntStream;

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
