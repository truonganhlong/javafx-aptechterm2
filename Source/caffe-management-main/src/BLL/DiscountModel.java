/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Discount;
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
public class DiscountModel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<String> ReadValue(int id) {
        try {
            DiscountModel model = new DiscountModel();
            Discount discount = model.ReadOne(id);
            List<String> list = new ArrayList<>();
            list.add(discount.getName());
            String sql = "SELECT name FROM [Discount]";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("name").equals(discount.getName())) {
                    continue;
                } else {
                    String name = rs.getString("name");
                    list.add(name);
                }
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

    public Discount ReadOne(int id) {
        try {
            String sql = "SELECT * FROM [Discount] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Discount discount = new Discount();
                discount.setId(rs.getInt("id"));
                discount.setName(rs.getString("name"));
                discount.setValue(rs.getFloat("value"));
                return discount;
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

    public int ReadId(String name) {
        try {
            String sql = "SELECT id FROM [Discount] WHERE name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                return id;
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
    public Discount ReadName(String name) {
        try {
            String sql = "SELECT * FROM [Discount] WHERE name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Discount discount = new Discount();
                discount.setId(rs.getInt("id"));
                discount.setName(rs.getString("name"));
                discount.setValue(rs.getFloat("value"));
                return discount;
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

    public static void main(String[] args) {
        DiscountModel model = new DiscountModel();
        System.out.println(model.ReadValue(1));
    }
}
