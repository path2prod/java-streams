package com.path2prod.section9.tdd;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.path2prod.Basket;
import com.path2prod.BasketItem;
import com.path2prod.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Section9 {
        public static List<Number> challenge1() {
        List.of("1", "-1", "invalid", "two", "2.0");
        return null;
    }

    public static List<Product> challenge2() {
        String p0 = """
                {"productName": "product0", "price": 0.3}
                """;

        String p1 = """
                {"name": "product1", "price": 2.3}
                """;

        String p2 = """
                {"name": "product2", "price": 5}
                """;

        String p3 = """
                {"displayName": "product3", "price": 5.1}
                """;

        ObjectMapper mapper = new ObjectMapper();
        Collection<Exception> exceptions = new ConcurrentLinkedQueue<>();

        List.of(p0, p1, p2, p3);



        return null;
    }

    public static Basket challenge3(){
        ObjectMapper mapper = new ObjectMapper();

        List<BasketItem> itemsOnstock = List.of(
            new BasketItem(new Product(2.5, "p1"), 3),
            new BasketItem(new Product(7.5, "p2"), 4),
            new BasketItem(new Product(1, "p3"), 1),
            new BasketItem(new Product(4.5, "p4"), 600)
        );

        return new Basket(itemsOnstock);
    }

}
