package com.path2prod.section2.tdd;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.path2prod.Person;
import com.path2prod.Utils;

public class Section2 {

    public static List<Person> challenge1(){
        return Utils.buildPersonList().stream()
        .toList();
    }

    public static List<String> challenge2(){
        Utils.buildProductList();
        return null;
    }

    public static List<String> challenge3(){
        return List.of("Fox","Alpha","Tango","Papa","XRay").stream().toList();
    }

    public static List<String> challenge4(){
        return List.of("Fox","Alpha","Tango","Papa","XRay").stream().toList();
    }

    public static List<Integer> challenge5(){
       List<Integer> nums = IntStream.rangeClosed(1, 5).boxed().toList(); 
       return Stream.of(nums,nums,nums).flatMap(List::stream).toList();
    }

    public static List<Integer> challenge6(){
        return IntStream.rangeClosed(1, 25).boxed().toList();
    }

    public static int challenge7(){
      return 0;
    }

}
