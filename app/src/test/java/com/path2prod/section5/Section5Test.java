package com.path2prod.section5;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section5.tdd.Section5;

public class Section5Test {

    @Test
    @DisplayName("Calculate the sum of a large array of numbers plus 5")
    void challenge1(){
        assertEquals(2_000_000_005, Section5.challenge1());

    }

    @Test
    @DisplayName("Find all prime numbers in a range using parallel streams")
    void challenge2(){
        assertEquals(148_933, Section5.challenge2()); 
    }
}
