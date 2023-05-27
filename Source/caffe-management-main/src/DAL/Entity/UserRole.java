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
public class UserRole {
    private int id;
    private int user_id;
    private int role_id;

    public UserRole() {
    }

    public UserRole(int id, int user_id, int role_id) {
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "UserRole{" + "id=" + id + ", user_id=" + user_id + ", role_id=" + role_id + '}';
    }
    
    
}
