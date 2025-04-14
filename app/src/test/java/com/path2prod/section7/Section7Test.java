package com.path2prod.section7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section7.tdd.Section7;

public class Section7Test {

    @Test
    @DisplayName("Define a custom collector for enhancing decimal coordeantes transforming to DMM format and joining with colon and wrapped by square bracket")
    void challenge1(){
        assertEquals("[40° 45.18';-73° 58.98']", Section7.challenge1());
    }

    @Test
    @DisplayName("Process a CSV file of sales data and calculate total revenue by product category")
    void challenge2() throws IOException{
        Map<String,Double> totalRevenueByCategory = Section7.challenge2();
        assertEquals(5, totalRevenueByCategory.size());
        assertEquals(43998.45, totalRevenueByCategory.get("Electronics"));
        assertEquals(4974.4, totalRevenueByCategory.get("Furniture"));
        assertEquals(1999.61, totalRevenueByCategory.get("Appliances"));
        assertEquals(998.0, totalRevenueByCategory.get("Stationery"));
        assertEquals(4198.8, totalRevenueByCategory.get("Accessories"));


    }

    @Test
    @DisplayName("Find the most frequently occurring word in a text file. Input: Path to text file.")
    void challenge3() throws IOException{
        List<Entry<String,Long>> maxWords = Section7.challenge3();
        assertEquals(1, maxWords.size());
        assertEquals("sed", maxWords.get(0).getKey());
        assertEquals(11, maxWords.get(0).getValue());

    }


    @Test
    @DisplayName("Flatten a list of lists into a single list using flatMap().")
    void challenge4(){
        List<Integer> fullList = Section7.challenge4();
        assertEquals(11, fullList.size());
        assertIterableEquals(List.of(0,1,2,3,4,5,6,7,8,9,10),fullList);
    }
}
