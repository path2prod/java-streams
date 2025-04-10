package com.path2prod.section6;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section6.tdd.Section6;


public class Section6Test {

    @Test
    @DisplayName("Use IntStream to find the sum of all integers from 1 to 100")
    void challenge1(){
        assertEquals(5050, Section6.challenge1());
    }

    @Test
    @DisplayName("Generate a DoubleStream of random values and find their average")
    void challenge2(){
        assertEquals(3.0, Section6.challenge2());
    }

    @Test
    @DisplayName("Use a LongStream to check if a number is prime")
    void challenge3(){
        assertIterableEquals(List.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L), Section6.challenge3());
    }
}
