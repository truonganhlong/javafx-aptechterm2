/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Entity;

import DAL.Enum.TableStatus;

/**
 *
 * @author Admin
 */
public class Table {
    private int id;
    private String name;
    private int table_status;
    private boolean status;

    public Table() {
    }

    public Table(int id, String name, int table_status, boolean status) {
        this.id = id;
        this.name = name;
        this.table_status = table_status;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTable_status() {
        return table_status;
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

    public void setTable_status(int table_status) {
        this.table_status = table_status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", name=" + name + ", table_status=" + table_status + ", status=" + status + '}';
    }
    
    
}
