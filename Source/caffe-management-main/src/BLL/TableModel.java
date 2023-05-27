/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Table;
import DAL.Enum.TableStatus;
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
public class TableModel {
    Connection con = null;
    PreparedStatement ps = null; 
    ResultSet rs = null;
    
    public List<Table> ReadAll(){
        try {
            List<Table> list = new ArrayList<>();
            String sql = "SELECT * FROM [Table] WHERE status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while(rs.next()){
                Table table = new Table();
                table.setId(rs.getInt("id"));
                table.setName(rs.getString("name"));
                table.setTable_status(rs.getInt("table_status"));
                table.setStatus(rs.getBoolean("status"));
                list.add(table);
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
    
    public Table ReadOne(String name){
        try {            
            String sql = "SELECT * FROM [Table] WHERE status = ? AND name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2, name);
            rs = ps.executeQuery();
            while(rs.next()){
                Table table = new Table();
                table.setId(rs.getInt("id"));
                table.setName(rs.getString("name"));
                table.setTable_status(rs.getInt("table_status"));
                table.setStatus(rs.getBoolean("status"));     
                return table;
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
    
    public int ReadId(int id){
        try {            
            String sql = "SELECT * FROM [Table] WHERE status = ? AND id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int value = rs.getInt("table_status");
                return value;
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
    
    public List<String> ReadFree(){
        try {
            List<String> list = new ArrayList<>();
            String sql = "SELECT * FROM [Table] WHERE table_status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            rs = ps.executeQuery();
            while(rs.next()){
                String table = rs.getString("name");
                list.add(table);
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
    
    public List<String> ReadUse(){
        try {
            List<String> list = new ArrayList<>();
            String sql = "SELECT * FROM [Table] WHERE table_status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            while(rs.next()){
                String table = rs.getString("name");
                list.add(table);
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
    
    public boolean UpdateStatusForUsing(int id){
        try {
            String sql = "UPDATE [Table] SET table_status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setInt(2, id);
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
    
    public boolean UpdateStatusForOrder(int id){
        try {
            String sql = "UPDATE [Table] SET table_status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, id);
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
    
    public boolean UpdateStatusForFree(int id){
        try {
            String sql = "UPDATE [Table] SET table_status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, id);
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
    
    public boolean Create(String name){
        try {
            String sql = "INSERT INTO [Table](name, table_status, status) VALUES (?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, 0);
            ps.setBoolean(3, true);
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
    
    public boolean Delete(int id){
       try {
            String sql = "UPDATE [Table] SET status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
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
    
    public String convertStatus(int id){
        TableModel model = new TableModel();
        int status = model.ReadId(id);
        if(status == 0){
            return "Free";
        } else if(status == 1){
            return "Ordered";
        } else {
            return "CurrentlyUse";
        }
    }
    
    
}
