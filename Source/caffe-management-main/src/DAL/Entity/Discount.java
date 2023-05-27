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
public class Discount {
    private int id;
    private String name;
    private float value;

    public Discount() {
    }

    public Discount(int id, String name, float value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Discount{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }
    
}
