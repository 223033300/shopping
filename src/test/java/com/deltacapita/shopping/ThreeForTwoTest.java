/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.shopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author manusaxena
 */
public class ThreeForTwoTest {

    @Test
    void testExecuteOfferMultiplesOfThree() {
       ThreeForTwo offer = new ThreeForTwo();
        double price = 30.0;
        int quantity = 6;
    double result = offer.executeOffer(price, quantity);
        Assertions.assertEquals(120.0, result);
    }

    @Test
    void testExecuteOfferNotMultiplesOfThree() {
        ThreeForTwo offer = new ThreeForTwo();
        double price = 30.0;
        int quantity = 7;
        double result = offer.executeOffer(price, quantity);
        Assertions.assertEquals(150.0, result);
    }

}
