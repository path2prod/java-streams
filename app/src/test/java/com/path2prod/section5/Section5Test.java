package com.path2prod.section5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

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

    @Test
    @DisplayName("Create a stream from a text file and count word frequency")
    void challenge3() throws IOException{
        assertEquals(4, Section5.challenge3());
    }

}
