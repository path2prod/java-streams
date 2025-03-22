package com.path2prod.section2.complete;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.path2prod.Person;
import com.path2prod.Product;
import com.path2prod.Utils;

public class Section2 {

    public static List<Person> challenge1(){
        return Utils.buildPersonList().stream()
        .filter(person -> person.age() >= 18)
        .toList();
    }

    public static List<String> challenge2(){
        return Utils.buildProductList().stream().map(Product::name).toList();
    }

    public static List<String> challenge3(){
        return List.of("Fox","Alpha","Tango","Papa","XRay").stream().sorted(Comparator.naturalOrder()).map(String::toLowerCase).toList();
    }

    public static List<String> challenge4(){
        return List.of("Fox","Alpha","Tango","Papa","XRay").stream().sorted(Comparator.reverseOrder()).map(String::toUpperCase).toList();
    }

    public static List<Integer> challenge5(){
       List<Integer> nums = IntStream.rangeClosed(1, 5).boxed().toList(); 
       return Stream.of(nums,nums,nums).flatMap(List::stream).distinct().toList();
    }

    public static List<Integer> challenge6(){
        return IntStream.rangeClosed(1, 25).boxed().skip(5).limit(10).toList();
    }

}
