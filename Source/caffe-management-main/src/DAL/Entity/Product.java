/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String name;
    private int category_id;
    private int unit_id;
    private float price;
    private int quantity;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int created_by;
    private int updated_by;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, int category_id, int unit_id, float price, int quantity, Timestamp created_at, Timestamp updated_at, int created_by, int updated_by, boolean status) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.unit_id = unit_id;
        this.price = price;
        this.quantity = quantity;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category_id=" + category_id + ", unit_id=" + unit_id + ", price=" + price + ", quantity=" + quantity + ", created_at=" + created_at + ", updated_at=" + updated_at + ", created_by=" + created_by + ", updated_by=" + updated_by + ", status=" + status + '}';
    }
        
}
