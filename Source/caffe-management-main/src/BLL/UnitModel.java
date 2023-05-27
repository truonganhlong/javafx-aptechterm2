/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.Unit;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UnitModel {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<String> ReadValue(int id) {
        try {
            UnitModel model = new UnitModel();
            Unit unit = model.ReadOne(id);
            List<String> list = new ArrayList<>();
            list.add(unit.getName());
            String sql = "SELECT name FROM [Unit]";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("name").equals(unit.getName())) {
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

    public Unit ReadOne(int id) {
        try {
            String sql = "SELECT * FROM [Unit] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unit unit = new Unit();
                unit.setId(rs.getInt("id"));
                unit.setName(rs.getString("name"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    unit.setCreated_at(null);
                } else {
                    unit.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    unit.setUpdated_at(null);
                } else {
                    unit.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    unit.setCreated_by(0);
                } else {
                    unit.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    unit.setUpdated_by(0);
                } else {
                    unit.setUpdated_by(updatedBy);
                }
                unit.setStatus(rs.getBoolean("status"));
                return unit;
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
            String sql = "SELECT id FROM [Unit] WHERE name = ?";
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

    public boolean Create(String name, int userId) {
        try {
            String sql = "INSERT INTO [Unit](name,created_at,created_by,status) VALUES (?,?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, userId);
            ps.setBoolean(4, true);
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

    public boolean Update(String name, int userId, int id) {
        try {
            String sql = "UPDATE [Unit] SET name = ?, updated_at = ?, updated_by = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, userId);
            ps.setInt(4, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public boolean UpdateStatus(int userId, int id) {
        try {
            CategoryModel model = new CategoryModel();
            String sql = "UPDATE [Unit] SET updated_at = ?, updated_by = ?, status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(2, userId);           
            boolean status = !model.ReadOne(id).isStatus();
            ps.setBoolean(3, status);
            ps.setInt(4, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public List<Unit> ReadAll() {
        try {
            List<Unit> list = new ArrayList<>();
            String sql = "SELECT * FROM [Unit]";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unit category = new Unit();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    category.setCreated_at(null);
                } else {
                    category.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    category.setUpdated_at(null);
                } else {
                    category.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    category.setCreated_by(0);
                } else {
                    category.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    category.setUpdated_by(0);
                } else {
                    category.setUpdated_by(updatedBy);
                }
                category.setStatus(rs.getBoolean("status"));
                list.add(category);
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
}
