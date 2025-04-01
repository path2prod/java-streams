package com.path2prod.section3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.Employee;
import com.path2prod.Product;
import com.path2prod.section3.tdd.Section3;

class Section3Test {

    @Test
    @DisplayName("Group a list of employees by department - using Gather API")
    void test_challenge1(){
        Map<String,List<Employee>> employeesByDepartament = Section3.challenge1();
        assertEquals(3, employeesByDepartament.keySet().size());
        employeesByDepartament.keySet().forEach( key -> {
            assertTrue(List.of("d1","d2","d3").contains(key));
        });

        assertEquals(3, employeesByDepartament.get("d1").size());
        employeesByDepartament.get("d1").forEach(employee -> {
            assertTrue(List.of("person-d1-1","person-d1-2","person-d1-3").contains(employee.name()));
        });

        assertEquals(2, employeesByDepartament.get("d2").size());
        employeesByDepartament.get("d2").forEach(employee -> {
            assertTrue(List.of("person-d2-1","person-d2-2").contains(employee.name()));
        });


        assertEquals(1, employeesByDepartament.get("d3").size());
        employeesByDepartament.get("d3").forEach(employee -> {
            assertTrue(List.of("person-d3-1").contains(employee.name()));
        });

    }

    @Test
    @DisplayName("Group a list of employees by department - using Collectors")
    void test_challenge2(){
        Map<String,List<Employee>> employeesByDepartament = Section3.challenge2();
        assertEquals(3, employeesByDepartament.keySet().size());
        employeesByDepartament.keySet().forEach( key -> {
            assertTrue(List.of("d1","d2","d3").contains(key));
        });

        assertEquals(3, employeesByDepartament.get("d1").size());
        employeesByDepartament.get("d1").forEach(employee -> {
            assertTrue(List.of("person-d1-1","person-d1-2","person-d1-3").contains(employee.name()));
        });

        assertEquals(2, employeesByDepartament.get("d2").size());
        employeesByDepartament.get("d2").forEach(employee -> {
            assertTrue(List.of("person-d2-1","person-d2-2").contains(employee.name()));
        });


        assertEquals(1, employeesByDepartament.get("d3").size());
        employeesByDepartament.get("d3").forEach(employee -> {
            assertTrue(List.of("person-d3-1").contains(employee.name()));
        });
    }

    @Test
    @DisplayName("Partition total students into passing and failing based on grades (passing >= 60)")
    void test_challenge3(){
        Map<Boolean,Long> studentScore = Section3.challenge3();
        assertEquals(2, studentScore.keySet().size());

        assertEquals(4, studentScore.get(true));
        assertEquals(5, studentScore.get(false));
    }

    @Test
    @DisplayName("Calculate the average of all numbers in a list")
    void test_challenge4(){
        assertEquals(5.5, Section3.challenge4());
        
    }

    @Test
    @DisplayName("Find the top 2 most expensive products")
    void test_challenge5(){
        List<Product> topProducts = Section3.challenge5();
        assertEquals(2, topProducts.size());
        assertEquals("product2", topProducts.get(0).name());
        assertEquals("product3", topProducts.get(1).name());
    }

    @Test
    @DisplayName("Concatenate multiple streams into a single stream")
    void test_challenge6(){
        assertEquals("This is challenge 6", Section3.challenge6());
    }
        

}
