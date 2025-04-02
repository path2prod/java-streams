package com.path2prod.section4.tdd;

import java.util.DoubleSummaryStatistics;
import java.util.Map;

import com.path2prod.Book;
import com.path2prod.Product;
import com.path2prod.Transaction;

public class Section4 {

        public static Map<String,Long> challenge1(){
        Book.buildBookList().stream();
        return null;
    }

    public static DoubleSummaryStatistics challenge2(){
        Product.buildProductList().stream();
        return null;
    }

    public static Map<String,Double> challenge3(){
        Transaction.buildTransactionList().stream();
        return null;
    }
}
