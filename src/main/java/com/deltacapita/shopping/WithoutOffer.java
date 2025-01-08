package com.deltacapita.shopping;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manusaxena
 */
public class WithoutOffer implements IOffer{
     
    @Override
    public double executeOffer(double price, int quantity) {
        return price * quantity;
    }
}
