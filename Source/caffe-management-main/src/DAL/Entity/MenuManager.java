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
public class MenuManager {
    private int id;
    private String name;
    private String category;
    private String unit;
    private float price;
    private int quantity;
    private String status;

    public MenuManager() {
    }

    public MenuManager(int id, String name, String category, String unit, float price, int quantity, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getUnit() {
        return unit;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuManager{" + "id=" + id + ", name=" + name + ", category=" + category + ", unit=" + unit + ", price=" + price + ", quantity=" + quantity + ", status=" + status + '}';
    }
    
    
}
