package com.path2prod.section9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.path2prod.Basket;
import com.path2prod.Product;
import com.path2prod.section9.tdd.Section9;

@WireMockTest(httpPort = 8080)
public class Section9Test {

    @Test
    @DisplayName("Builds a pipeline that converts strings to numbers, handling various format exceptions.")
    void challenge1(){
        List<Number> numbers = Section9.challenge1();
        assertEquals(3, numbers.size());
        assertEquals(1, numbers.get(0));
        assertEquals(-1, numbers.get(1));
        assertEquals(2.0, numbers.get(2));
    }

    @Test
    @DisplayName("Build a stream of JSON products and parse them, properly managing parsing exceptions.")
    void challenge2(){
        List<Product> products = Section9.challenge2();
        assertEquals(2, products.size());
    }

    @Test
    @DisplayName("Sanitise a basket items")
    void challenge3(){
        Basket basket = Section9.challenge3();
        assertEquals(2, basket.items().size());
        assertEquals(30.0, basket.getTotal());
        assertEquals(3, basket.items().get(0).quantity());
        assertEquals(5, basket.items().get(1).quantity());
    }

}
