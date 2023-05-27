/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Role;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoleModel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String CheckRoleName(int roleId) {
        try {
            String sql = "SELECT * FROM [Role] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setStatus(rs.getBoolean("status"));
                return role.getName();
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

    public List<String> ReadName() {
        try {
            List<String> list = new ArrayList<>();
            String sql = "SELECT name FROM [Role]";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);            
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                list.add(name);
            }
            return list;
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
    }
    
    public int CheckRoleId(String name) {
        try {
            String sql = "SELECT * FROM [Role] WHERE name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setStatus(rs.getBoolean("status"));
                return role.getId();
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
}
