/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.DataManager;
import DAL.Entity.Order;
import DAL.Entity.OrderManager;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class OrderModel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;        
    
    

    public boolean CreateOrder(Integer customerId, int userId, int productId, int quantity, String note, Integer table_id, boolean payment_now, int status) {
        try {            
            ProductModel productModel = new ProductModel();
            DiscountModel discountModel = new DiscountModel();
            UserModel userModel = new UserModel();
            float price = productModel.ReadOne(productId).getPrice();
            Integer qty = productModel.ReadOne(productId).getQuantity();
            if (productModel.UpdateQuantity(quantity, productId)) {
                String sql = "INSERT INTO [Order](user_id, product_id, quantity, total_price, table_id, payment_now, note, created_at, created_by, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                if (customerId == null) {
                    ps.setNull(1, Types.NULL);
                    ps.setFloat(4, quantity * price);
                } else {
                    ps.setInt(1, customerId);
                    ps.setFloat(4, quantity * price * discountModel.ReadOne(userModel.ReadOne(customerId).getDiscount_id()).getValue());
                }
                ps.setInt(2, productId);
                ps.setInt(3, quantity);
                if (table_id == null) {
                    ps.setNull(5, Types.NULL);
                } else {
                    ps.setInt(5, table_id);
                }
                ps.setBoolean(6, payment_now);
                if (note == null) {
                    ps.setNull(7, Types.NULL);
                } else {
                    ps.setString(7, note);
                }
                ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                ps.setInt(9, userId);
                ps.setInt(10, status);
                ps.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Dont have enough quantity in storage!");
                return false;
            }
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

    public List<Order> ReadOrderToPay(int tableId) {
        try {
            List<Order> list = new ArrayList<>();
            String sql = "SELECT * FROM [Order] WHERE table_id = ? AND status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tableId);
            ps.setInt(2, 0);
            rs = ps.executeQuery();            
            while (rs.next()) {                
                Order order = new Order();
                order.setId(rs.getInt("id"));               
                Integer user_id = rs.getInt("user_id");
                if (rs.wasNull()) {
                    order.setUser_id(Types.NULL);
                } else {
                    order.setUser_id(user_id);
                }
                order.setProduct_id(rs.getInt("product_id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setTotal_price(rs.getFloat("total_price"));
                Integer table_id = rs.getInt("table_id");
                if (rs.wasNull()) {
                    order.setTable_id(Types.NULL);
                } else {
                    order.setTable_id(table_id);
                }
                order.setPayment_now(rs.getBoolean("payment_now"));
                String note = rs.getString("note");
                if (rs.wasNull()) {
                    order.setNote(null);
                } else {
                    order.setNote(note);
                }
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    order.setCreated_at(null);
                } else {
                    order.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    order.setUpdated_at(null);
                } else {
                    order.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    order.setCreated_by(0);
                } else {
                    order.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    order.setUpdated_by(0);
                } else {
                    order.setUpdated_by(updatedBy);
                }
                order.setStatus(rs.getInt("status"));
                list.add(order);
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

    public boolean UpdateOrderPayLater(Integer userId, int tableId) {
        try {
            OrderModel orderModel = new OrderModel();
            List<Order> order = orderModel.ReadOrderToPay(tableId);
            DiscountModel discountModel = new DiscountModel();
            UserModel userModel = new UserModel();
            String sql = "UPDATE [Order] SET user_id = ?, total_price = total_price * ?, status = ? WHERE table_id = ? AND status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            if (userId == null) {
                ps.setNull(1, Types.NULL);                
                ps.setInt(2, 1);
                ps.setInt(3, 1);
                ps.setInt(4, tableId);
                ps.setInt(5, 0);
            } else {
                ps.setInt(1, userId);  
                ps.setFloat(2, discountModel.ReadOne(userModel.ReadOne(userId).getDiscount_id()).getValue());
                ps.setInt(3, 1);                
                ps.setInt(4, tableId);
                ps.setInt(5, 0);
            }
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

    public List<DataManager> ReadOrderData(String begin, String end) {
        try {
            ProductModel productModel = new ProductModel();
            UserModel userModel = new UserModel();
            List<DataManager> list = new ArrayList<>();
            String sql = "SELECT * FROM [Order] WHERE created_at BETWEEN ? AND ? AND status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, begin);
            ps.setString(2, end);
            ps.setInt(3, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                DataManager obj = new DataManager();
                obj.setProduct(productModel.ReadOne(rs.getInt("product_id")).getName());
                obj.setQuantity(rs.getInt("quantity"));
                obj.setTotal_price(rs.getFloat("total_price"));
                obj.setTime(rs.getTimestamp("created_at"));
                obj.setOrderBy(userModel.ReadOne(rs.getInt("created_by")).getUsername());
                list.add(obj);
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
    
    public OrderManager AddToList(String name, float price, int quantity, String note) {
        float total = price * quantity;
        OrderManager obj = new OrderManager(name,price,quantity,total,note);           
        return obj;
    }
    
    public List<OrderManager> ConvertOrderManager(List<Order> orders){
        try {
            OrderModel model = new OrderModel();
            ProductModel productModel = new ProductModel();
            List<OrderManager> list = new ArrayList();
            for(int i = 0; i < orders.size(); i++){
                OrderManager order = new OrderManager();
                order.setName(productModel.ReadOne(orders.get(i).getProduct_id()).getName());
                order.setPrice(productModel.ReadOne(orders.get(i).getProduct_id()).getPrice());
                order.setQuantity(orders.get(i).getQuantity());
                order.setTotal(orders.get(i).getTotal_price());
                order.setNote(orders.get(i).getNote());
                list.add(order);                
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    public float totalPriceForChart(String begin, String end){
        try {
            float totalPrice = 0;
            OrderModel model = new OrderModel();
            for(int i = 0; i < model.ReadOrderData(begin, end).size(); i ++){
                totalPrice += model.ReadOrderData(begin, end).get(i).getTotal_price();
            }
            return totalPrice;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public List<DataManager> ReadAllOrderData(String begin, String end){
        try {
            ProductModel productModel = new ProductModel();
            UserModel userModel = new UserModel();
            List<DataManager> list = new ArrayList<>();
            String sql = "SELECT [Order].product_id, SUM([Order].quantity) AS quantity, SUM([Order].total_price) AS total_price FROM [Order] INNER JOIN [Product] ON [Order].product_id = [Product].id WHERE [Order].created_at BETWEEN ? AND ? AND [Order].status = ? GROUP BY [Order].product_id";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, begin);
            ps.setString(2, end);
            ps.setInt(3, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                DataManager obj = new DataManager();
                obj.setProduct(productModel.ReadOne(rs.getInt("product_id")).getName());
                obj.setQuantity(rs.getInt("quantity"));
                obj.setTotal_price(rs.getFloat("total_price"));                
                list.add(obj);
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
    public static void main(String[] args) {
        //IPath path = project.getLocation();
        OrderModel model = new OrderModel();
        System.out.println(model.ReadAllOrderData("2022-12-01", "2022-12-16"));
    }
}
