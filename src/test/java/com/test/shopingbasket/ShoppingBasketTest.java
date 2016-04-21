package com.test.shopingbasket;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShoppingBasketTest {

    public static final String APPLE = "Apple";
    public static final String ORANGE = "Orange";

    private static ShoppingBasket shoppingBasket;

    @BeforeClass
    public static void classSetup() {
        shoppingBasket = new ShoppingBasket();
    }
    @Test
    public void can_create_shopping_basket() {
        assertThat(new ShoppingBasket(), notNullValue());
    }

    @Test
    public void when_single_item_is_added_then_return_the_price_of_item_as_total() {
        BigDecimal totalPrice = shoppingBasket.calculatePrice(APPLE);
        assertThat(totalPrice, is(new BigDecimal("0.60"))); // each Apple is 60p
    }

    @Test
    public void when_multiple_item_are_added_then_return_the_price_of_items_as_total() {
        BigDecimal totalPrice = shoppingBasket.calculatePrice(APPLE, ORANGE);
        assertThat(totalPrice, is(new BigDecimal("0.85"))); // each Apple is 60p and orange is 25p
    }

    @Test
    public void check_the_total_price_when_multiple_mixed_items_are_added() {
        BigDecimal totalPrice = shoppingBasket.calculatePrice(APPLE, ORANGE, APPLE, APPLE, ORANGE);
        assertThat(totalPrice, is(new BigDecimal("2.30"))); // each Apple is 60p and orange is 25p
    }

    @Test
    public void when_two_items_with_bogof_promotion_are_added_then_promotion_should_applied() {
        BigDecimal totalPrice = shoppingBasket.calculatePrice(APPLE, APPLE);
        assertThat(totalPrice, is(new BigDecimal("0.60"))); // each Apple is 60p
    }

    @Test
    public void can_apply_3ForThePriceOf2_promotion() {
        BigDecimal totalPrice = shoppingBasket.calculatePrice(ORANGE, ORANGE, ORANGE);
        assertThat(totalPrice, is(new BigDecimal("0.50"))); // each Orange is 25p
    }

}
