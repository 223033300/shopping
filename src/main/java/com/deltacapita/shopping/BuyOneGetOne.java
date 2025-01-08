/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.shopping;

/**
 *
 * @author manusaxena
 */
public class BuyOneGetOne implements IOffer{
    
    @Override
    public double executeOffer(double price, int quantity) {
        int eligibleQuantity = (quantity / 2) + (quantity % 2);
        return price * eligibleQuantity;
    }
}
