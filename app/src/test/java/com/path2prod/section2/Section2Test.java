package com.path2prod.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.Person;
import com.path2prod.section2.tdd.Section2;

class Section2Test {

    @Test
    @DisplayName("Filter a list of Person objects to find all adults (age >= 18)")
    void test_challenge1(){
        List<Person> expected18orOverPersons = Section2.challenge1();
        assertEquals(2, expected18orOverPersons.size());
        expected18orOverPersons.forEach(person -> {
            assertTrue(List.of("over-eighteen","just-eighteen").contains(person.name()));
        });
    }

    @Test
    @DisplayName("Transform a list of Product objects to just their names")
    void test_challenge2(){
        List<String> expectedProductNamesList = Section2.challenge2();
        assertEquals(3, expectedProductNamesList.size());
        expectedProductNamesList.forEach(product -> {
            assertTrue(List.of("product1","product2","product3").contains(product));
        });
        
    }

    @Test
    @DisplayName("Sort a list of strings alphabetically, then convert to lowercase")
    void test_challenge3(){
        List<String> expectedSortedList = Section2.challenge3();
        assertEquals(5, expectedSortedList.size());
        expectedSortedList.forEach(word -> {
            assertTrue( List.of("alpha","fox","papa","tango","xray").contains(word));
        });
    }

    @Test
    @DisplayName("Sort reversed a list of strings alphabetically, then convert to uppercase")
    void test_challenge4(){
        List<String> expectedSortedList = Section2.challenge4();
        assertEquals(5, expectedSortedList.size());
        expectedSortedList.forEach(word -> {
            assertTrue( List.of("XRAY","TANGO","PAPA","FOX","ALPHA").contains(word));
        });
    }

    @Test
    @DisplayName("Remove duplicate elements from a list")
    void test_challenge5(){
        List<Integer> uniqueNums = Section2.challenge5();
        assertEquals(5, uniqueNums.size());
        uniqueNums.forEach(num -> {
              assertTrue(List.of(1,2,3,4,5).contains(num));  
        });
    }

    @Test
    @DisplayName("Skip the first 5 elements of a stream and limit the result to 10 elements")
    void test_challenge6(){
        List<Integer> expectedNums = Section2.challenge6();
        assertEquals(10, expectedNums.size());
        expectedNums.forEach(num ->{
            assertTrue(List.of(6,7,8,9,10,11,12,13,14,15,16).contains(num));
        }); 
        
    }

}
