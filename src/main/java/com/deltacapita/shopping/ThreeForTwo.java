/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.shopping;

/**
 *
 * @author manusaxena
 */
public class ThreeForTwo implements IOffer {
    
    @Override
    public double executeOffer(double price, int quantity) {
        int eligibleQuantity = (quantity / 3 * 2) + (quantity % 3);
        return price * eligibleQuantity;
    }
}
