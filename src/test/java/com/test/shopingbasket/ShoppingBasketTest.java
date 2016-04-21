package com.test.shopingbasket;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShoppingBasketTest {

    @Test
    public void can_create_shopping_basket() {
        assertThat(new ShoppingBasket(), notNullValue());
    }

    @Test
    public void when_single_item_is_added_then_return_the_price_of_item_as_total() {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        BigDecimal totalPrice = shoppingBasket.calculatePrice("Apple");

        assertThat(totalPrice, is(new BigDecimal("0.60"))); // each Apple is 60p
    }
}
