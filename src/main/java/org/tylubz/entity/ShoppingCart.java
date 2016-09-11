package org.tylubz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 10.09.2016.
 */
public class ShoppingCart {
    private int totalAmount;
    private float totalPrice;
    private List<ShoppingUnit> shoppingList;

    public ShoppingCart(){
        shoppingList = new ArrayList<ShoppingUnit>();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ShoppingUnit> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<ShoppingUnit> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void addUnit(ShoppingUnit unit){
        shoppingList.add(unit);
        totalAmount += unit.getAmount();
        totalPrice += unit.getPrice();
    }
}
