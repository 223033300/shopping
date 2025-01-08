/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deltacapita.model;

import com.deltacapita.shopping.IOffer;
import com.deltacapita.shopping.WithoutOffer;

/**
 *
 * @author manusaxena
 */
public class Item {
    private String name;
    private double price;
    private int quantity;
    private IOffer offer;
    
    public Item(String name, double price, int quantity, IOffer offer) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.offer = offer != null ? offer : new WithoutOffer(); 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public IOffer getOffer() {
        return offer;
    }
    
    public double calculatePrice() {
        return offer.executeOffer(price, quantity); 
    }

}
