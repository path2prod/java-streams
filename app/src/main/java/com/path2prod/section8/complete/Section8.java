package com.path2prod.section8.complete;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import com.path2prod.MinMax;

public class Section8 {
    public static boolean challenge1(){
        return List.of(1,3,5,7,9).stream().allMatch(number -> number%2!=0);
    }

    public static boolean challenge2(){
        return List.of(1,4,6,8,10).stream().anyMatch(number -> number%2!=0);
    }

    public static boolean challenge3(){
        return List.of(2,4,6,8,10).stream().noneMatch(number -> number%2!=0);
    }

    public static int challenge4(){
       Collector<String, Set<String>, Integer> distinctCount =  Collector.of(
            HashSet::new,
            Set::add,
            (set1, set2) -> {
                set1.addAll(set2);
                return set1;
            },
            Set::size
        );
        return List.of("banana","orange","apple","banana","mango","orange")
        .stream()
        .collect(distinctCount);
    }

    public static MinMax<Integer> challenge5(){
        Collector<Integer, MinMaxCollector<Integer>, MinMax<Integer>> c =  Collector.of(
            MinMaxCollector::new,
            MinMaxCollector::accumulate,
            MinMaxCollector::combine,
            MinMaxCollector::toMinMax
        );
        return List.of(5, 2, 9, 1, 7, 3, 8, 4, 6).stream().collect(c);

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
