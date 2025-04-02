package com.path2prod.section4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.DoubleSummaryStatistics;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section4.tdd.Section4;

public class Section4Test {

    @Test
    @DisplayName("Group books by author and count books per author")
    void challenge1(){
        Map<String,Long> totalBooksByAuthor = Section4.challenge1();
        assertEquals(4, totalBooksByAuthor.size());

        assertEquals(3, totalBooksByAuthor.get("author1"));
        assertEquals(4, totalBooksByAuthor.get("author2"));
        assertEquals(1, totalBooksByAuthor.get("author3"));
        assertEquals(2, totalBooksByAuthor.get("author4"));
    }

    @Test
    @DisplayName("Find the count, sum, average, min, and max price of all products")
    void challenge2(){
        DoubleSummaryStatistics stats = Section4.challenge2();
        assertEquals(3, stats.getCount());
        assertEquals(5.0, stats.getMax());
        assertEquals(2.4, stats.getMin());
        assertEquals(10.8, stats.getSum());
        assertEquals(3.6, stats.getAverage());
    }


    @Test
    @DisplayName("Group transactions by currency and calculate the sum for each currency")
    void challenge3(){
        Map<String,Double> totalTransactions = Section4.challenge3();
        assertEquals(3, totalTransactions.size());
        assertEquals(43.5, totalTransactions.get("currency1"));
        assertEquals(71.0, totalTransactions.get("currency2"));
        assertEquals(134.2, totalTransactions.get("currency3"));
        
    }
}
