package com.path2prod;

import java.util.List;
import java.util.stream.Collectors;

public record Basket(List<BasketItem> items) {

    public double getTotal(){
        return items.stream().collect(Collectors.summarizingDouble(it -> it.quantity() * it.product().price())).getSum();
    }

}
