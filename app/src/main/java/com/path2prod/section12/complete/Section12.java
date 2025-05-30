package com.path2prod.section12.complete;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.path2prod.Event;
import com.path2prod.Product;

public class Section12 {

    public static List<Integer> challenge1(){
        Collector<Integer,LongestSequence,List<Integer>> longestSeqCollector = 
        Collector.of(LongestSequence::new, LongestSequence::accumulator, LongestSequence::combiner, LongestSequence::finisher);
        
        return List.of(2,3,4,9,6,4,5,7,3,1,2,3,4,5,6,7,8,9,1,3,5,6,7,8,0,2,4,5,6,3,0).stream().collect(longestSeqCollector);
    }

    public static List<Product> challenge2(){
         return List.of(
            new Product(2.4,"product1"),
            new Product(5.0,"product3"),
            new Product(3.4,"product3"),
            new Product(0.4,"product2")
            ).stream()
            .sorted(Comparator.comparingDouble(Product::price).thenComparing(Product::name, Comparator.nullsLast(Comparator.naturalOrder())))
            .toList();
    }

    public static Map<Character,Long> challenge3(){
        String input = "Hello-W0rld!!!!";

        return input.chars()
        .filter(Character::isLetter)
        .map(Character::toLowerCase)
        .mapToObj( c -> (char) c)
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()
        ));
    }

    public static Map<Integer, Map<Integer, Map<Integer, List<Event>>>> challenge4(){
        return Event.buildEvents()
        .stream()
        .collect(
            Collectors.groupingBy( (event) -> event.scheduledAt().getYear(),
            Collectors.groupingBy( (event) -> event.scheduledAt().getMonthValue(),
            Collectors.groupingBy( (event) -> event.scheduledAt().getDayOfMonth(), Collectors.toList()))));
    }
}
