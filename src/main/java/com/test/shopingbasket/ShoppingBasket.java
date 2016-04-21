package com.test.shopingbasket;

import java.math.BigDecimal;

public class ShoppingBasket {
    public BigDecimal calculatePrice(String... items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for(String item : items ) {

            switch(item) {
                case "Apple":
                    totalPrice = totalPrice.add(new BigDecimal("0.60"));
                    break;
                case "Orange":
                    totalPrice = totalPrice.add(new BigDecimal("0.25"));
                    break;
            }
        }

        return totalPrice;
    }
}
