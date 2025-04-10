package com.path2prod.section6.complete;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Section6 {

    public static int challenge1(){
        return IntStream.rangeClosed(1, 100).sum();
    }

    public static double challenge2(){
        return IntStream.rangeClosed(1, 5).asDoubleStream().average().getAsDouble();
    }

    public static List<Long> challenge3(){
        return LongStream.rangeClosed(1, 100).collect(ArrayList::new
        ,(list,l) -> { if(isPrime(l)) list.add(l);},List::addAll);
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
