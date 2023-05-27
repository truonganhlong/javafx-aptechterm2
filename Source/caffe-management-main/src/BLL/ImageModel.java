/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Image;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class ImageModel {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Image Read(int productId){
        try {
            String sql = "SELECT * FROM [Image] WHERE product_id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while(rs.next()){
                Image image = new Image();
                image.setProduct_id(rs.getInt("product_id"));
                String link = rs.getString("link");
                if(rs.wasNull()){
                    image.setLink(null);
                } else {
                    image.setLink(link);
                } 
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    image.setCreated_at(null);
                } else {
                    image.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    image.setUpdated_at(null);
                } else {
                    image.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    image.setCreated_by(0);
                } else {
                    image.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    image.setUpdated_by(0);
                } else {
                    image.setUpdated_by(updatedBy);
                }
                image.setStatus(rs.getBoolean("status"));
                return image;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }
    
    public boolean Create(int productId, String link, int userId){
        try {
            String sql = "INSERT INTO [Image](product_id,link,created_at,created_by,status) VALUES (?,?,?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            link = link.replace("\\", "\\\\");
            ps.setInt(1, productId);
            ps.setString(2, link);
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(4, userId);
            ps.setBoolean(5, true);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
    }
    
    public boolean Update(int productId, String link, int userId){
        try {
            String sql = "UPDATE [Image] SET link = ?, updated_at = ?, updated_by = ? WHERE product_id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            link = link.replace("\\", "\\\\");
            ps.setString(1, link);
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, userId);
            ps.setInt(4, productId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
    }
}
