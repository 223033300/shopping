/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.model;

import com.deltacapita.shopping.WithoutOffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author manusaxena
 */
public class BasketTest {

    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    void testAddItem() {
        Item apple = new Item("Apple", 35.0, 1, new WithoutOffer());
        basket.addItem(apple);
        Assertions.assertEquals(35, basket.calculateTotal());
    }

    @Test
    void testCalculateTotal() {
        Item apple = new Item("Apple", 35.0, 1, new WithoutOffer());
        Item banana = new Item("Banana", 20.0, 1, new WithoutOffer());
        basket.addItem(apple);
        basket.addItem(banana);
        double total = basket.calculateTotal();
        Assertions.assertEquals(55.0, total, 0.01);
    }

    @Test
    void testEmptyBasket() {
        double total = basket.calculateTotal();
        Assertions.assertEquals(0.0, total, 0.01);
    }
}
