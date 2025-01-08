/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manusaxena
 */
public class Basket {
    private final List<Item> items = new ArrayList<>();
    
     public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        double totalCost = 0.0;
        for (Item item : items) {
            totalCost += item.calculatePrice(); 
        }
        return totalCost;
    }
}
