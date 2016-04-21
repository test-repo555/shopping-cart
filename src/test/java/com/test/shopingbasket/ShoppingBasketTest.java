package com.test.shopingbasket;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShoppingBasketTest {

    @Test
    public void can_create_shopping_basket() {
        assertThat(new ShoppingBasket(), notNullValue());
    }
}
