package com.path2prod;

import java.util.List;

public class Utils {

   public static List<Person> buildPersonList(){
        return List.of(new Person(18, "just-eighteen"),new Person(15, "less-eighteen"),new Person(34,"over-eighteen"));
    }

    public static List<Product> buildProductList(){
        return List.of(new Product(2.4,"product1"),new Product(5.0, "product2"),new Product(3.4,"product3"));
    }
}
