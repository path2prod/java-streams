package com.path2prod.section12.tdd;

import java.util.List;
import java.util.Map;

import com.path2prod.Event;
import com.path2prod.Product;

public class Section12 {

        public static List<Integer> challenge1(){
        return List.of(2,3,4,9,6,4,5,7,3,1,2,3,4,5,6,7,8,9,1,3,5,6,7,8,0,2,4,5,6,3,0);
    }

    public static List<Product> challenge2(){
         return List.of(
            new Product(2.4,"product1"),
            new Product(5.0,"product3"),
            new Product(3.4,"product3"),
            new Product(0.4,"product2")
            );
    }

    public static Map<Character,Long> challenge3(){
        String input = "Hello-W0rld!!!!";
        return null;
    }

    public static Map<Integer, Map<Integer, Map<Integer, List<Event>>>> challenge4(){
        List<Event> events = Event.buildEvents();
        return null;
    }

}
