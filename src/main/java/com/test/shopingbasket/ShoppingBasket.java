package com.test.shopingbasket;

import java.math.BigDecimal;

public class ShoppingBasket {
    public BigDecimal calculatePrice(String... items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        int countApples = 0;
        for(String item : items ) {

            switch(item) {
                case "Apple":
                    countApples++;
                    totalPrice = totalPrice.add(new BigDecimal("0.60"));
                    break;
                case "Orange":
                    totalPrice = totalPrice.add(new BigDecimal("0.25"));
                    break;
            }
        }

        int discountMultiplier = countApples / 2;

        BigDecimal ApplePrice = new BigDecimal("0.60");
        BigDecimal discountOnApples = ApplePrice.multiply(BigDecimal.valueOf(discountMultiplier));

        totalPrice = totalPrice.subtract(discountOnApples);

        return totalPrice;
    }
}
