package com.path2prod;

import java.util.List;

public record Product(double price,String name) {
    public Product{
        if (price<0){
            throw new IllegalArgumentException(String.format("price %f not valid for product %s", price, name));
        }
    }

        public static List<Product> buildProductList(){
        return List.of(
            new Product(2.4,"product1"),
            new Product(5.0,"product2"),
            new Product(3.4,"product3"));
    }
}
