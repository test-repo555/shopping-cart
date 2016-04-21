package com.test.shopingbasket;

import java.math.BigDecimal;

public class ShoppingBasket {
    public BigDecimal calculatePrice(String... items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        int countApples = 0, countOranges = 0;
        for(String item : items ) {

            switch(item) {
                case "Apple":
                    countApples++;
                    totalPrice = totalPrice.add(new BigDecimal("0.60"));
                    break;
                case "Orange":
                    countOranges++;
                    totalPrice = totalPrice.add(new BigDecimal("0.25"));
                    break;
            }
        }

        int appleDiscountMultiplier = countApples / 2;
        BigDecimal applePrice = new BigDecimal("0.60");
        BigDecimal discountOnApples = applePrice.multiply(BigDecimal.valueOf(appleDiscountMultiplier));

        int orangesDiscountMultiplier = countOranges / 3;
        BigDecimal orangePrice = new BigDecimal("0.25");
        BigDecimal discountOnOranges = orangePrice.multiply(BigDecimal.valueOf(orangesDiscountMultiplier));
        totalPrice = totalPrice.subtract(discountOnOranges);

        return totalPrice;
    }
}
