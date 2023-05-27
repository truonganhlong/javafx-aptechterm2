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
public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String dob;
    private String email;
    private String phone;
    private int avatar_id;
    private int discount_id;
    private float total_contribute;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int created_by;
    private int updated_by;
    private boolean status;

    public User() {
    }

    public User(int id, String username, String password, String fullname, String dob, String email, String phone, int avatar_id, int discount_id, float total_contribute, Timestamp created_at, Timestamp updated_at, int created_by, int updated_by, boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.avatar_id = avatar_id;
        this.discount_id = discount_id;
        this.total_contribute = total_contribute;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatar_id() {
        return avatar_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public float getTotal_contribute() {
        return total_contribute;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatar_id(int avatar_id) {
        this.avatar_id = avatar_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public void setTotal_contribute(float total_contribute) {
        this.total_contribute = total_contribute;
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
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", avatar_id=" + avatar_id + ", discount_id=" + discount_id + ", total_contribute=" + total_contribute + ", created_at=" + created_at + ", updated_at=" + updated_at + ", created_by=" + created_by + ", updated_by=" + updated_by + ", status=" + status + '}';
    }
    
    
}
