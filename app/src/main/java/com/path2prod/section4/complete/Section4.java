package com.path2prod.section4.complete;

import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import com.path2prod.Book;
import com.path2prod.Product;
import com.path2prod.Transaction;

public class Section4 {

    public static Map<String,Long> challenge1(){
        return Book.buildBookList().stream().collect(Collectors.groupingBy(Book::author, Collectors.counting()));
    }

    public static DoubleSummaryStatistics challenge2(){
        return Product.buildProductList().stream().collect(Collectors.summarizingDouble(Product::price));
    }

    public static Map<String,Double> challenge3(){
        return Transaction.buildTransactionList().stream()
        .collect(Collectors.groupingBy(Transaction::currency, Collectors.reducing(0.0, Transaction::amount, (a1,a2) -> a1+a2)));
    }

}
