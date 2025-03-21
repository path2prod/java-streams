package com.path2prod.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section1.tdd.Section1;

class Section1Test {

    @Test 
    @DisplayName("Create a stream of integers 1-10 and filter out all even numbers")
    void test_challenge1() {

        assertEquals(5, Section1.challenge1().count());
        assertTrue(List.of(1, 3, 5, 7, 9).containsAll(Section1.challenge1().toList()));
    
    }

    @Test 
    @DisplayName("Convert a list of strings to uppercase using map()")
    void test_challenge2() {
        List<String> expected = List.of("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH");
        expected.forEach(word -> assertTrue(Section1.challenge2().contains(word)));
    }

    @Test 
    @DisplayName("Sum all numbers in an array using reduce()")
    void test_challenge3() {
        assertEquals(55, Section1.challenge3());
    }

    @Test 
    @DisplayName("Find the maximum value in a list of integers")
    void test_challenge4() {
        assertEquals(10, Section1.challenge4());
    }

    @Test 
    @DisplayName("Check none element in a list of strings contains the letter 'a'")
    void test_challenge5() {
       assertTrue(Section1.challenge5());
    }

    @Test 
    @DisplayName("Check if any element in a list of strings contains the letter 'a'")
    void test_challenge6() {
        assertTrue(Section1.challenge6());
    }

}
