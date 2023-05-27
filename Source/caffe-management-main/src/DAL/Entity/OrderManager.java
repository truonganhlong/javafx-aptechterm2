/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Entity;

/**
 *
 * @author Admin
 */
public class OrderManager {
    private String name;
    private float price;
    private int quantity;
    private float total;
    private String note;

    public OrderManager() {
    }

    public OrderManager(String name, float price, int quantity, float total, String note) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal() {
        return total;
    }

    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderManager{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + ", total=" + total + ", note=" + note + '}';
    }
    
    
}
