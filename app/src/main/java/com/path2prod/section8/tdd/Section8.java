package com.path2prod.section8.tdd;

import java.util.List;

import com.path2prod.MinMax;

public class Section8 {
    public static boolean challenge1(){
        List.of(1,3,5,7,9);
        return false;
    }

    public static boolean challenge2(){
        List.of(1,4,6,8,10);
        return false;
    }

    public static boolean challenge3(){
        List.of(2,4,6,8,10);
        return false;
    }

    public static int challenge4(){
        List.of("banana","orange","apple","banana","mango","orange");
        return 0;
    }

    public static MinMax<Integer> challenge5(){
        List.of(5, 2, 9, 1, 7, 3, 8, 4, 6);
        return new MinMax<Integer>(0, 0);

    }


    private static class MinMaxCollector<T extends Comparable<T>> {
        private T min;
        private T max;
    
        void accumulate(T item) {
            if (min == null || item.compareTo(min) < 0) {
                min = item;
            }
            if (max == null || item.compareTo(max) > 0) {
                max = item;
            }
        }
    
        MinMaxCollector<T> combine(MinMaxCollector<T> other) {
            if (other.min != null) {
                accumulate(other.min);
            }
            if (other.max != null) {
                accumulate(other.max);
            }
            return this;
        }
    
        MinMax<T> toMinMax() {
            return new MinMax<>(min, max);
        }
    
    }
}
