package com.path2prod;

public record BasketItem(Product product,int quantity) {
    public BasketItem{
        if (quantity<0){
            throw new IllegalArgumentException(String.format("quantity %d not valid for basket item", quantity));
        }
    }

}
