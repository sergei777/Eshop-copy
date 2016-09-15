package org.tylubz.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Stores the product items in a cart
 *
 * @author Sergei
 */
public class ShoppingCart {
    private int totalAmount; //total amount of items
    private float totalPrice; //total price
    private List<ShoppingUnit> shoppingList; //list of items

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

    /**
     * Adds new item to the shopping cart
     * and changes total price and amount
     * @param unit item of the shopping cart
     */
    public void addUnit(ShoppingUnit unit){
        shoppingList.add(unit);
        totalAmount += unit.getAmount();
        totalPrice += unit.getPrice();
    }

    public void removeUnitById(int id){
        ListIterator<ShoppingUnit> iter = shoppingList.listIterator();
        while(iter.hasNext()){
            ShoppingUnit unit = iter.next();
            if(unit.getId()==(id)){
                totalAmount -= unit.getAmount();
                totalPrice -= unit.getPrice();
                iter.remove();
            }
        }
    }
}
