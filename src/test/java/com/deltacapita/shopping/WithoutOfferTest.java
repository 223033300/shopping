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
public class WithoutOfferTest {

    @Test
    void testExecuteOffer() {

        WithoutOffer offer = new WithoutOffer();
        double price = 25.0;
        int quantity = 4;
        double result = offer.executeOffer(price, quantity);
        Assertions.assertEquals(100.0, result);
    }
}
