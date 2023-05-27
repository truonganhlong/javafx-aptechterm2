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
public class Image {
    private int id;
    private int product_id;
    private String link;
    private Timestamp created_at;
    private Timestamp updated_at;
    private int created_by;
    private int updated_by;
    private boolean status;

    public Image() {
    }

    public Image(int id, int product_id, String link, Timestamp created_at, Timestamp updated_at, int created_by, int updated_by, boolean status) {
        this.id = id;
        this.product_id = product_id;
        this.link = link;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getLink() {
        return link;
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

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setLink(String link) {
        this.link = link;
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
        return "Image{" + "id=" + id + ", product_id=" + product_id + ", link=" + link + ", created_at=" + created_at + ", updated_at=" + updated_at + ", created_by=" + created_by + ", updated_by=" + updated_by + ", status=" + status + '}';
    }
    
    
}
