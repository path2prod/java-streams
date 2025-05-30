package com.path2prod.section12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.Event;
import com.path2prod.Product;
import com.path2prod.section12.tdd.Section12;

public class Section12Test {

    @Test
    @DisplayName("Find the longest sequence of consecutive integers in a list of unsorted numbers")
    void challenge1(){
        List<Integer> seq =  Section12.challenge1();
        assertEquals(9, seq.size());
    }

    @Test
    @DisplayName("Implement a custom comparator to sort products by price, then by name if prices are equal")
    void challenge2(){
        List<Product> sortedProducts = Section12.challenge2();
        assertEquals(4, sortedProducts.size());
        assertEquals(0.4, sortedProducts.get(0).price());
        assertEquals(2.4, sortedProducts.get(1).price());
        assertEquals(3.4, sortedProducts.get(2).price());
        assertEquals(5, sortedProducts.get(3).price());
    }

    @Test
    @DisplayName("Create a frequency map of characters in a string, ignoring case and non-alphabetic characters")
    void challenge3(){
        Map<Character,Long> freqMap = Section12.challenge3();
        assertEquals(1, freqMap.get('h'));
        assertEquals(1, freqMap.get('e'));
        assertEquals(3, freqMap.get('l'));
        assertEquals(1, freqMap.get('o'));
        assertEquals(1, freqMap.get('w'));
        assertEquals(1, freqMap.get('r'));
        assertEquals(1, freqMap.get('d'));
    }

    @Test
    @DisplayName("Write a collector that performs hierarchical grouping by year, month and day")
    void challenge4(){
        Map<Integer, Map<Integer, Map<Integer, List<Event>>>> sortedEvents = Section12.challenge4();
        assertEquals(2, sortedEvents.size());
        assertEquals(4, sortedEvents.get(LocalDate.now().getYear()).size());
        assertEquals(1, sortedEvents.get(LocalDate.now().minusYears(1).getYear()).size());

    }

}
