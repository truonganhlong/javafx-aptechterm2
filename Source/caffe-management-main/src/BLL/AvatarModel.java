/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Avatar;
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
public class AvatarModel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String CheckAvatar(int avatarId) {
        try {
            String sql = "SELECT * FROM [Avatar] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, avatarId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Avatar avatar = new Avatar();
                avatar.setId(rs.getInt("id"));                
                String link = rs.getString("link");
                if (rs.wasNull()) {
                    avatar.setLink(null);
                } else {
                    avatar.setLink(link);
                }
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    avatar.setCreated_at(null);
                } else {
                    avatar.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    avatar.setUpdated_at(null);
                } else {
                    avatar.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    avatar.setCreated_by(1);
                } else {
                    avatar.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    avatar.setUpdated_by(1);
                } else {
                    avatar.setUpdated_by(updatedBy);
                }
                avatar.setStatus(rs.getBoolean("status"));
                return avatar.getLink();
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
    
    public boolean Update(int id, String link, int userId){
        try {
            String sql = "UPDATE [Avatar] SET link = ?, updated_at = ?, updated_by = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            link = link.replace("\\", "\\\\");
            ps.setString(1, link);            
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, userId);
            ps.setInt(4, id);
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
    
    public int Create(String link, int userId){
        try {
            String sql = "INSERT INTO [Avatar](link,created_at,created_by,status) OUTPUT INSERTED.ID VALUES (?,?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            link = link.replace("\\", "\\\\");
            ps.setString(1, link);            
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, userId);
            ps.setBoolean(4, true);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("ID");
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        AvatarModel model = new AvatarModel();
        System.out.println(model.Create("test",1));
    }
}
