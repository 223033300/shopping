package com.deltacapita.shopping;

import com.deltacapita.model.Basket;
import com.deltacapita.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import jdk.jfr.Description;

public class ShoppingTest {

    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    @Description("Verify the total cost of a single item added to the basket.")
    void testAddSingleItem() {
        Item apple = new Item("Apple", 0.35, 2, new WithoutOffer());
        basket.addItem(apple);
        Assertions.assertEquals(0.70, basket.calculateTotal(), 0.01);
    }

    @Test
    @Description("Verify the total cost when adding multiple items with no offers.")
    void testAddMultipleItemsWithoutOffer() {
        Item apple = new Item("Apple", 0.35, 2, new WithoutOffer());
        Item banana = new Item("Banana", 0.20, 3, new WithoutOffer());
        basket.addItem(apple);
        basket.addItem(banana);
        double total = basket.calculateTotal();
        Assertions.assertEquals(1.30, total, 0.01);
    }

    @Test
    @Description("Verify the total cost when applying BuyOneGetOne offer on items.")
    void testAddItemWithBuyOneGetOneOffer() {
        Item melon = new Item("Melon", 0.50, 3, new BuyOneGetOne());
        basket.addItem(melon);
        double total = basket.calculateTotal();
        Assertions.assertEquals(1.00, total, 0.01);
    }

    @Test
    @Description("Verify the total cost when applying a combination of ThreeForTwo and BuyOneGetOne offers.")
    void testAddItemsWithMultipleOffers() {
        Item apple = new Item("Apple", 1.00, 3, new ThreeForTwo());
        Item banana = new Item("Banana", 0.50, 5, new BuyOneGetOne());
        basket.addItem(apple);
        basket.addItem(banana);
        double total = basket.calculateTotal();
        Assertions.assertEquals(3.50, total, 0.01);
    }

    @Test
    @Description("Verify that the total cost of an empty basket is 0.")
    void testEmptyBasket() {
        double total = basket.calculateTotal();
        Assertions.assertEquals(0.0, total, 0.01);
    }

    @Test
    @Description("Verify the total cost when adding a large quantity of items.")
    void testLargeQuantityItems() {
        Item apple = new Item("Apple", 0.99, 1000000, new WithoutOffer());
        basket.addItem(apple);
        double total = basket.calculateTotal();
        Assertions.assertEquals(990000.0, total, 0.01);
    }

    @Test
    @Description("Verify that adding an item with a negative price throws an exception.")
    void testInvalidItemPrice() {
        try {
            Item invalidItem = new Item("Invalid", -10.0, 5, new WithoutOffer());
            basket.addItem(invalidItem);
            basket.calculateTotal();
            Assertions.fail("Expected exception for negative price");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Price cannot be negative", e.getMessage());
        }
    }

    @Test
    @Description("Verify that items with negative or zero quantity result in a total of 0.")
    void testInvalidItemQuantity() {
        Item invalidQuantityItem = new Item("Invalid Item", 10.0, -5, new WithoutOffer());
        basket.addItem(invalidQuantityItem);
        double total = basket.calculateTotal();
        Assertions.assertEquals(0.0, total, 0.01);
    }

    @Test
    @Description("Verify that BuyOneGetOne offer works correctly on odd quantities.")
    void testBuyOneGetOneOddQuantity() {
        Item apple = new Item("Apple", 0.50, 5, new BuyOneGetOne());
        basket.addItem(apple);
        double total = basket.calculateTotal();
        Assertions.assertEquals(1.50, total, 0.01);
    }

    @Test
    @Description("Verify that ThreeForTwo offer works correctly on even quantities.")
    void testThreeForTwoEvenQuantity() {
        Item apple = new Item("Apple", 0.50, 6, new ThreeForTwo());
        basket.addItem(apple);
        double total = basket.calculateTotal();
        Assertions.assertEquals(2.00, total, 0.01);
    }

    @Test
    @Description("Verify that an item without an offer is processed as a regular item.")
    void testItemWithNullOffer() {
        Item itemWithNullOffer = new Item("Item", 10.0, 3, null);
        basket.addItem(itemWithNullOffer);
        double total = basket.calculateTotal();
        Assertions.assertEquals(30.0, total, 0.01);
    }

    @Test
    @Description("Verify the performance when adding a large number of items.")
    void testLargeNumberOfItems() {
        for (int i = 0; i < 100000; i++) {
            Item item = new Item("Item" + i, 1.0, 1, new WithoutOffer());
            basket.addItem(item);
        }
        double total = basket.calculateTotal();
        Assertions.assertEquals(100000.0, total, 0.01);
    }

    @Test
    @Description("Verify that adding an item with zero price results in an error or failure.")
    void testZeroItemPriceWithoutOffer() {
        Item invalidItem = new Item("Zero Price Item", 0.0, 1, new WithoutOffer());
        basket.addItem(invalidItem);
        double total = basket.calculateTotal();
        Assertions.assertTrue(total > 0, "Expected total to be greater than 0, but it was 0 due to zero price.");
    }

    @Test
    @Description("Verify that adding an item with zero quantity results in an error or failure.")
    void testZeroItemQuantityWithoutOffer() {
        Item invalidItem = new Item("Zero Quantity Item", 10.0, 0, new WithoutOffer());
        basket.addItem(invalidItem);
        double total = basket.calculateTotal();
        Assertions.assertTrue(total > 0, "Expected total to be greater than 0, but it was 0 due to zero quantity.");
    }

    @Test
    @Description("Verify that BuyOneGetOne offer shouldn't apply to a single item.")
    void testBuyOneGetOneWithSingleItem() {
        Item invalidItem = new Item("Apple", 0.50, 1, new BuyOneGetOne());
        basket.addItem(invalidItem);
        double total = basket.calculateTotal();
        Assertions.assertTrue(total > 0.50, "Expected total to be greater than 0.50, but it was incorrectly calculated.");
    }

    @Test
    @Description("Test adding multiple valid items and one invalid item with negative price.")
    void testAddMultipleValidItemsWithInvalidItem() {
        try {
            Item apple = new Item("Apple", 0.50, 3, new WithoutOffer());
            Item banana = new Item("Banana", 0.30, 2, new WithoutOffer());
            basket.addItem(apple);
            basket.addItem(banana);

            Item invalidItem = new Item("Invalid Apple", -1.0, 5, new WithoutOffer());
            basket.addItem(invalidItem);

            basket.calculateTotal();
            Assertions.fail("Expected exception for negative price but it passed.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Price cannot be negative", e.getMessage());
        }
    }

    @Test
    @Description("Test adding multiple valid items and one invalid item with negative quantity.")
    void testAddMultipleValidItemsWithInvalidQuantity() {
        try {
            Item apple = new Item("Apple", 0.50, 3, new WithoutOffer());
            Item banana = new Item("Banana", 0.30, 2, new WithoutOffer());
            basket.addItem(apple);
            basket.addItem(banana);

            Item invalidItem = new Item("Invalid Banana", 0.30, -3, new WithoutOffer());
            basket.addItem(invalidItem);

            basket.calculateTotal();
            Assertions.fail("Expected exception for negative quantity but it passed.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Quantity cannot be negative", e.getMessage());
        }
    }
}
