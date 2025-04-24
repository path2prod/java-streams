package com.path2prod.section8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section8.tdd.Section8;

public class Section8Test {

    @DisplayName("Return if a stream of integer contains only odd numbers")
    @Test
    void challenge1(){
        assertTrue(Section8.challenge1());
    }


    @DisplayName("Return if a stream of integer contains any odd numbers")
    @Test
    void challenge2(){
        assertTrue(Section8.challenge2());

    }

    @DisplayName("Return if a stream of integer contains none odd numbers")
    @Test
    void challenge3(){
        assertTrue(Section8.challenge3());
    }

    @DisplayName("Count total distinct words")
    @Test
    void challenge4(){
        assertEquals(4, Section8.challenge4());
    }

    @DisplayName("Find both the minimum and maximum value in a single stream pass")
    @Test
    void challenge5(){
        assertEquals(1, Section8.challenge5().min());
        assertEquals(9, Section8.challenge5().max());
    }
}
