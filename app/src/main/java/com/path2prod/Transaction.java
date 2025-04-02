package com.path2prod;

import java.util.List;

public record Transaction(int id, double amount,String currency) {
    public Transaction{
        if(amount<0.0){
            throw new IllegalArgumentException(String.format("invalid amount %d for transaction %i", amount,id));
        }
    }

    public static List<Transaction> buildTransactionList(){
        return List.of(
            new Transaction(1, 10, "currency1"),
            new Transaction(2, 5.5, "currency2"),
            new Transaction(3, 24.2, "currency3"),
            new Transaction(4, 0.5, "currency1"),
            new Transaction(5, 64.5, "currency2"),
            new Transaction(6, 10, "currency3"),
            new Transaction(7, 10, "currency1"),
            new Transaction(8, 23, "currency1"),
            new Transaction(9, 1, "currency2"),
            new Transaction(10, 100, "currency3")       
             );
    }

}
