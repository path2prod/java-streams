package com.path2prod.section13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section13.tdd.Section13;

public class Section13Test {

    @Test
    @DisplayName("Calculate Body Mass Index implementing a currying function")
    void challenge1(){
        List<Double> bodyMassIndexes = Section13.challenge1();
        assertEquals(3, bodyMassIndexes.size());
        assertEquals(27.14, bodyMassIndexes.get(0));
        assertEquals(21.60, bodyMassIndexes.get(1));
        assertEquals(20.31, bodyMassIndexes.get(2));
    }

    @Test
    @DisplayName("Chaining functional operations for adding title for person over 18")
    void challenge2(){
        List<String> nameList = Section13.challenge2();
        assertEquals(2,nameList.size());
        assertEquals("Mr/Mrs JUST-EIGHTEEN", nameList.get(0));
        assertEquals("Mr/Mrs OVER-EIGHTEEN", nameList.get(1));
    }

}
