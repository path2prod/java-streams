package com.path2prod;

public record Product(double price,String name) {
    public Product{
        if (price<0){
            throw new IllegalArgumentException(String.format("price %f not valid for product %s", price, name));
        }
    }
}
