/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Entity;

import DAL.Enum.OrderStatus;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int id;
    private int user_id;
    private int product_id;
    private int quantity;
    private float total_price;
    private int table_id;
    private boolean payment_now;
    private String note;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int created_by;
    private int updated_by;
    private int status;

    public Order() {
    }

    public Order(int id, int user_id, int product_id, int quantity, float total_price, int table_id, boolean payment_now, String note, Timestamp created_at, Timestamp updated_at, int created_by, int updated_by, int status) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.table_id = table_id;
        this.payment_now = payment_now;
        this.note = note;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public int getTable_id() {
        return table_id;
    }

    public boolean isPayment_now() {
        return payment_now;
    }

    public String getNote() {
        return note;
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

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public void setPayment_now(boolean payment_now) {
        this.payment_now = payment_now;
    }

    public void setNote(String note) {
        this.note = note;
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

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", quantity=" + quantity + ", total_price=" + total_price + ", table_id=" + table_id + ", payment_now=" + payment_now + ", note=" + note + ", created_at=" + created_at + ", updated_at=" + updated_at + ", created_by=" + created_by + ", updated_by=" + updated_by + ", status=" + status + '}';
    }
    
    
}
