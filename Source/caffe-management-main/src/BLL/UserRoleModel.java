/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.UserRole;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserRoleModel {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public int CheckRoleId(int userId){
        try {
            String sql = "SELECT * FROM [UserRole] WHERE user_id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
                UserRole userRole = new UserRole();
                userRole.setId(rs.getInt("id"));
                userRole.setUser_id(rs.getInt("user_id"));
                userRole.setRole_id(rs.getInt("role_id"));
                return userRole.getRole_id();
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
    
    public boolean Create(int userId, int roleId){
        try {
            String sql = "INSERT INTO [UserRole](user_id, role_id) VALUES (?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, roleId);
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
    
    public boolean Update(int userId, int roleId){
        try {
            String sql = "UPDATE [UserRole] SET role_id = ? WHERE user_id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            ps.setInt(2, userId);
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
