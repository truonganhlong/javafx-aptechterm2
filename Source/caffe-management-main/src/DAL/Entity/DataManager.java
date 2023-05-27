/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Entity;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class DataManager {    
    private String product;
    private int quantity;
    private float total_price;
    private Timestamp time;
    private String orderBy;

    public DataManager() {
    }

    public DataManager(String product, int quantity, float total_price, Timestamp time, String orderBy) {
        this.product = product;
        this.quantity = quantity;
        this.total_price = total_price;
        this.time = time;
        this.orderBy = orderBy;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "DataManager{" + "product=" + product + ", quantity=" + quantity + ", total_price=" + total_price + ", time=" + time + ", orderBy=" + orderBy + '}';
    }
    
    
}
