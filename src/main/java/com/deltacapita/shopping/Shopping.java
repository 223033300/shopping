/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.deltacapita.shopping;

import com.deltacapita.model.Basket;
import com.deltacapita.model.Item;

/**
 *
 * @author manusaxena
 */
public class Shopping {

    public static void main(String[] args) {
        
        Item apple = new Item("Apple", 0.35, 2, new WithoutOffer()); 
        Item banana = new Item("Banana", 0.20, 1, new WithoutOffer()); 
        Item melon = new Item("Melon", 0.50, 3, new BuyOneGetOne()); 
        Item lime = new Item("Lime", 0.15, 5, new ThreeForTwo()); 

       
        Basket basket = new Basket();
        basket.addItem(apple);
        basket.addItem(banana);
        basket.addItem(melon);
        basket.addItem(lime);

        
        double totalCost = basket.calculateTotal();
        System.out.printf("Total cost: Rs %.2f\n", totalCost);
    }
}
