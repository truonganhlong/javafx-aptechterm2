/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.MenuManager;
import DAL.Entity.Product;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class ProductModel {

    String active;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> ReadAll() {
        try {
            List<Product> list = new ArrayList<>();
            String sql = "SELECT * FROM [Product]";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                int category_id = rs.getInt("category_id");
                if (rs.wasNull()) {
                    product.setCategory_id(0);
                } else {
                    product.setCategory_id(category_id);
                }
                int unit_id = rs.getInt("unit_id");
                if (rs.wasNull()) {
                    product.setUnit_id(0);
                } else {
                    product.setUnit_id(unit_id);
                }
                product.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    product.setQuantity(0);
                } else {
                    product.setQuantity(quantity);
                }
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    product.setCreated_at(null);
                } else {
                    product.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    product.setUpdated_at(null);
                } else {
                    product.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    product.setCreated_by(0);
                } else {
                    product.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    product.setUpdated_by(0);
                } else {
                    product.setUpdated_by(updatedBy);
                }
                product.setStatus(rs.getBoolean("status"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public List<MenuManager> ReadForTable(int pageIndex) {
        try {
            List<MenuManager> list = new ArrayList<>();
            String sql = "SELECT [Product].id, [Product].name, [Category].name AS category_name, [Unit].name AS unit_name, price, quantity, [Product].status FROM [Product], [Category], [Unit] WHERE [Product].category_id = [Category].id AND [Product].unit_id = [Unit].id";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MenuManager obj = new MenuManager();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                String category_name = rs.getString("category_name");
                if (rs.wasNull()) {
                    obj.setCategory(null);
                } else {
                    obj.setCategory(category_name);
                }
                String unit_name = rs.getString("unit_name");
                if (rs.wasNull()) {
                    obj.setUnit(null);
                } else {
                    obj.setUnit(unit_name);
                }
                obj.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    obj.setQuantity(0);
                } else {
                    obj.setQuantity(quantity);
                }
                if (rs.getBoolean("status") == true) {
                    active = "active";
                } else {
                    active = "inactive";
                }
                obj.setStatus(active);
                list.add(obj);
            }            
            int begin = (pageIndex - 1) * 10;
            int end = pageIndex * 10;
            if (end <= list.size()) {
                return list.subList(begin, end);
            } else {
                return list.subList(begin, list.size());
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public Product ReadOne(int id) {
        try {
            String sql = "SELECT * FROM [Product] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                int category_id = rs.getInt("category_id");
                if (rs.wasNull()) {
                    product.setCategory_id(0);
                } else {
                    product.setCategory_id(category_id);
                }
                int unit_id = rs.getInt("unit_id");
                if (rs.wasNull()) {
                    product.setUnit_id(0);
                } else {
                    product.setUnit_id(unit_id);
                }
                product.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    product.setQuantity(0);
                } else {
                    product.setQuantity(quantity);
                }
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    product.setCreated_at(null);
                } else {
                    product.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    product.setUpdated_at(null);
                } else {
                    product.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    product.setCreated_by(0);
                } else {
                    product.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    product.setUpdated_by(0);
                } else {
                    product.setUpdated_by(updatedBy);
                }
                product.setStatus(rs.getBoolean("status"));
                return product;
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public List<MenuManager> ReadForStatus(boolean status, int pageIndex) {
        try {
            List<MenuManager> list = new ArrayList<>();
            String sql = "SELECT [Product].id, [Product].name, [Category].name AS category_name, [Unit].name AS unit_name, price, quantity, [Product].status FROM [Product], [Category], [Unit] WHERE [Product].category_id = [Category].id AND [Product].unit_id = [Unit].id AND [Product].status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, status);            
            rs = ps.executeQuery();
            while (rs.next()) {
                MenuManager obj = new MenuManager();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                String category_name = rs.getString("category_name");
                if (rs.wasNull()) {
                    obj.setCategory(null);
                } else {
                    obj.setCategory(category_name);
                }
                String unit_name = rs.getString("unit_name");
                if (rs.wasNull()) {
                    obj.setUnit(null);
                } else {
                    obj.setUnit(unit_name);
                }
                obj.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    obj.setQuantity(0);
                } else {
                    obj.setQuantity(quantity);
                }
                if (rs.getBoolean("status") == true) {
                    active = "active";
                } else {
                    active = "inactive";
                }
                obj.setStatus(active);
                list.add(obj);
            }
            int begin = (pageIndex - 1) * 10;
            int end = pageIndex * 10;
            if (end <= list.size()) {
                return list.subList(begin, end);
            } else {
                return list.subList(begin, list.size());
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean Create(String name, Integer categoryId, Integer unitId, float price, Integer quantity, int userId) {
        try {
            String sql = "INSERT INTO [Product](name, category_id, unit_id, price, quantity, created_at, created_by, status) VALUES (?,?,?,?,?,?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            if (categoryId == null) {
                ps.setNull(2, Types.NULL);
            } else {
                ps.setInt(2, categoryId);
            }
            if (unitId == null) {
                ps.setNull(3, Types.NULL);
            } else {
                ps.setInt(3, unitId);
            }
            ps.setFloat(4, price);
            if (quantity == null) {
                ps.setNull(5, Types.NULL);
            } else {
                ps.setInt(5, quantity);
            }
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(7, userId);
            ps.setBoolean(8, true);
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

    public boolean Update(String name, Integer categoryId, Integer unitId, float price, Integer quantity, int userId, int id) {
        try {
            String sql = "UPDATE [Product] SET name = ?, category_id = ?, unit_id = ?, price = ?, quantity = ?, updated_at = ?, updated_by = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            if (categoryId == null) {
                ps.setNull(2, Types.NULL);
            } else {
                ps.setInt(2, categoryId);
            }
            if (unitId == null) {
                ps.setNull(3, Types.NULL);
            } else {
                ps.setInt(3, unitId);
            }
            ps.setFloat(4, price);
            if (quantity == null) {
                ps.setNull(5, Types.NULL);
            } else {
                ps.setInt(5, quantity);
            }
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(7, userId);
            ps.setInt(8, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean UpdateStatus(int id) {
        try {
            ProductModel model = new ProductModel();
            String sql = "UPDATE [Product] SET Status = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            boolean status = !model.ReadOne(id).isStatus();
            ps.setBoolean(1, status);
            ps.setInt(2, id);
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

    public List<MenuManager> SearchName(String name, int pageIndex) {
        try {
            List<MenuManager> list = new ArrayList<>();
            String sql = "SELECT [Product].id, [Product].name, [Category].name AS category_name, [Unit].name AS unit_name, price, quantity, [Product].status FROM [Product], [Category], [Unit] WHERE [Product].category_id = [Category].id AND [Product].unit_id = [Unit].id AND [Product].name LIKE ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                MenuManager obj = new MenuManager();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                String category_name = rs.getString("category_name");
                if (rs.wasNull()) {
                    obj.setCategory(null);
                } else {
                    obj.setCategory(category_name);
                }
                String unit_name = rs.getString("unit_name");
                if (rs.wasNull()) {
                    obj.setUnit(null);
                } else {
                    obj.setUnit(unit_name);
                }
                obj.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    obj.setQuantity(0);
                } else {
                    obj.setQuantity(quantity);
                }
                if (rs.getBoolean("status") == true) {
                    active = "active";
                } else {
                    active = "inactive";
                }
                obj.setStatus(active);
                list.add(obj);
            }
            int begin = (pageIndex - 1) * 10;
            int end = pageIndex * 10;
            if (end <= list.size()) {
                return list.subList(begin, end);
            } else {
                return list.subList(begin, list.size());
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean UpdateQuantity(int quantity, int id) {
        try {
            ProductModel model = new ProductModel();
            Integer storage = model.ReadOne(id).getQuantity();
            if (storage.equals(Types.NULL)) {
                return true;
            } else {
                String sql = "UPDATE [Product] SET quantity = ? WHERE id = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, model.ReadOne(id).getQuantity() - quantity);
                ps.setInt(2, id);
                ps.executeUpdate();
                return true;
            }
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

    public boolean AddQuantity(int id, int quantity) {
        try {
            ProductModel model = new ProductModel();
            Product product = model.ReadOne(id);
            System.out.println(product);
            String sql = "UPDATE [Product] SET quantity = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, product.getQuantity() + quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }

    }

    public List<MenuManager> ReadForCategory(int pageIndex, String categoryName) {
        try {
            List<MenuManager> list = new ArrayList<>();
            String sql = "SELECT [Product].id, [Product].name, [Category].name AS category_name, [Unit].name AS unit_name, price, quantity, [Product].status FROM [Product], [Category], [Unit] WHERE [Product].category_id = [Category].id AND [Product].unit_id = [Unit].id AND [Category].name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while (rs.next()) {
                MenuManager obj = new MenuManager();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                String category_name = rs.getString("category_name");
                if (rs.wasNull()) {
                    obj.setCategory(null);
                } else {
                    obj.setCategory(category_name);
                }
                String unit_name = rs.getString("unit_name");
                if (rs.wasNull()) {
                    obj.setUnit(null);
                } else {
                    obj.setUnit(unit_name);
                }
                obj.setPrice(rs.getFloat("price"));
                int quantity = rs.getInt("quantity");
                if (rs.wasNull()) {
                    obj.setQuantity(0);
                } else {
                    obj.setQuantity(quantity);
                }
                if (rs.getBoolean("status") == true) {
                    active = "active";
                } else {
                    active = "inactive";
                }
                obj.setStatus(active);
                list.add(obj);
            }            
            int begin = (pageIndex - 1) * 10;
            int end = pageIndex * 10;
            if (end <= list.size()) {
                return list.subList(begin, end);
            } else {
                return list.subList(begin, list.size());
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
    
    public int ReadName(String name){
        try {
            String sql = "SELECT * FROM [Product] WHERE name = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()){
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
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ProductModel model = new ProductModel();
        System.out.println(model.ReadForTable(1));
    }
}
