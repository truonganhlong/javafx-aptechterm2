/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Entity.EmpManager;
import DAL.Entity.Role;
import DAL.Entity.User;
import DAL.Entity.UserRole;
import DAL.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class UserModel {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User Login(String username) {
        try {
            String sql = "SELECT * FROM [User] WHERE username = ? AND status = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setBoolean(2, true);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                String dob = rs.getString("dob");
                if (rs.wasNull()) {
                    user.setDob(null);
                } else {
                    user.setDob(dob);
                }
                String email = rs.getString("email");
                if (rs.wasNull()) {
                    user.setEmail(null);
                } else {
                    user.setEmail(email);
                }
                String phone = rs.getString("phone");
                if (rs.wasNull()) {
                    user.setPhone(null);
                } else {
                    user.setPhone(phone);
                }
                int avatarId = rs.getInt("avatar_id");
                if (rs.wasNull()) {
                    user.setAvatar_id(1);
                } else {
                    user.setAvatar_id(avatarId);
                }
                int discountId = rs.getInt("discount_id");
                if (rs.wasNull()) {
                    user.setDiscount_id(1);
                } else {
                    user.setDiscount_id(discountId);
                }
                user.setTotal_contribute(rs.getFloat("total_contribute"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    user.setCreated_at(null);
                } else {
                    user.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    user.setUpdated_at(null);
                } else {
                    user.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    user.setCreated_by(1);
                } else {
                    user.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    user.setUpdated_by(1);
                } else {
                    user.setUpdated_by(updatedBy);
                }
                user.setStatus(rs.getBoolean("status"));
                return user;
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

    public User ReadOne(int userId) {
        try {
            String sql = "SELECT * FROM [User] WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                String dob = rs.getString("dob");
                if (rs.wasNull()) {
                    user.setDob(null);
                } else {
                    user.setDob(dob);
                }
                String email = rs.getString("email");
                if (rs.wasNull()) {
                    user.setEmail(null);
                } else {
                    user.setEmail(email);
                }
                String phone = rs.getString("phone");
                if (rs.wasNull()) {
                    user.setPhone(null);
                } else {
                    user.setPhone(phone);
                }
                int avatarId = rs.getInt("avatar_id");
                if (rs.wasNull()) {
                    user.setAvatar_id(0);
                } else {
                    user.setAvatar_id(avatarId);
                }
                int discountId = rs.getInt("discount_id");
                if (rs.wasNull()) {
                    user.setDiscount_id(0);
                } else {
                    user.setDiscount_id(discountId);
                }
                user.setTotal_contribute(rs.getFloat("total_contribute"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    user.setCreated_at(null);
                } else {
                    user.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    user.setUpdated_at(null);
                } else {
                    user.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    user.setCreated_by(0);
                } else {
                    user.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    user.setUpdated_by(0);
                } else {
                    user.setUpdated_by(updatedBy);
                }
                user.setStatus(rs.getBoolean("status"));
                return user;
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

    public User ReadName(String userName) {
        try {
            String sql = "SELECT * FROM [User] WHERE username = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                String dob = rs.getString("dob");
                if (rs.wasNull()) {
                    user.setDob(null);
                } else {
                    user.setDob(dob);
                }
                String email = rs.getString("email");
                if (rs.wasNull()) {
                    user.setEmail(null);
                } else {
                    user.setEmail(email);
                }
                String phone = rs.getString("phone");
                if (rs.wasNull()) {
                    user.setPhone(null);
                } else {
                    user.setPhone(phone);
                }
                int avatarId = rs.getInt("avatar_id");
                if (rs.wasNull()) {
                    user.setAvatar_id(0);
                } else {
                    user.setAvatar_id(avatarId);
                }
                int discountId = rs.getInt("discount_id");
                if (rs.wasNull()) {
                    user.setDiscount_id(0);
                } else {
                    user.setDiscount_id(discountId);
                }
                user.setTotal_contribute(rs.getFloat("total_contribute"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    user.setCreated_at(null);
                } else {
                    user.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    user.setUpdated_at(null);
                } else {
                    user.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    user.setCreated_by(0);
                } else {
                    user.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    user.setUpdated_by(0);
                } else {
                    user.setUpdated_by(updatedBy);
                }
                user.setStatus(rs.getBoolean("status"));
                return user;
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

    public List<User> ReadAll(int userId) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("admin")) {
                List<User> list = new ArrayList<>();
                String sql = "SELECT * FROM [User]";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    String dob = rs.getString("dob");
                    if (rs.wasNull()) {
                        user.setDob(null);
                    } else {
                        user.setDob(dob);
                    }
                    String email = rs.getString("email");
                    if (rs.wasNull()) {
                        user.setEmail(null);
                    } else {
                        user.setEmail(email);
                    }
                    String phone = rs.getString("phone");
                    if (rs.wasNull()) {
                        user.setPhone(null);
                    } else {
                        user.setPhone(phone);
                    }
                    int avatarId = rs.getInt("avatar_id");
                    if (rs.wasNull()) {
                        user.setAvatar_id(1);
                    } else {
                        user.setAvatar_id(avatarId);
                    }
                    int discountId = rs.getInt("discount_id");
                    if (rs.wasNull()) {
                        user.setDiscount_id(1);
                    } else {
                        user.setDiscount_id(discountId);
                    }
                    user.setTotal_contribute(rs.getFloat("total_contribute"));
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    if (rs.wasNull()) {
                        user.setCreated_at(null);
                    } else {
                        user.setCreated_at(createdAt);
                    }
                    Timestamp updatedAt = rs.getTimestamp("updated_at");
                    if (rs.wasNull()) {
                        user.setUpdated_at(null);
                    } else {
                        user.setUpdated_at(updatedAt);
                    }
                    int createdBy = rs.getInt("created_by");
                    if (rs.wasNull()) {
                        user.setCreated_by(1);
                    } else {
                        user.setCreated_by(createdBy);
                    }
                    int updatedBy = rs.getInt("updated_by");
                    if (rs.wasNull()) {
                        user.setUpdated_by(1);
                    } else {
                        user.setUpdated_by(updatedBy);
                    }
                    user.setStatus(rs.getBoolean("status"));
                    list.add(user);
                }
                return list;
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

    public String CheckRole(int userId) {
        try {
            UserRoleModel userRoleModel = new UserRoleModel();
            RoleModel roleModel = new RoleModel();
            return roleModel.CheckRoleName(userRoleModel.CheckRoleId(userId));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean Create(int userId, int roleId, String username, String password, String fullname, String dob, String email, String phone) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("admin") && model.ReadName(username) == null) {
                String sql = "INSERT INTO [User](username,password,fullname,dob,email,phone,avatar_id,discount_id,total_contribute,created_at,created_by,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                if (username == null) {
                    ps.setString(1, null);
                } else {
                    ps.setString(1, username);
                }
                if (password == null) {
                    ps.setString(2, null);
                } else {
                    ps.setString(2, password);
                }
                ps.setString(3, fullname);
                if (dob == null) {
                    ps.setString(4, null);
                } else {
                    ps.setString(4, dob);
                }
                if (email == null) {
                    ps.setString(5, null);
                } else {
                    ps.setString(5, email);
                }
                if (phone == null) {
                    ps.setString(6, null);
                } else {
                    ps.setString(6, phone);
                }
                ps.setInt(7, 1);
                ps.setInt(8, 1);
                ps.setFloat(9, 0);
                ps.setTimestamp(10, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                ps.setInt(11, userId);
                ps.setBoolean(12, true);
                ps.executeUpdate();
                User user = model.Login(username);
                UserRoleModel userRoleModel = new UserRoleModel();
                userRoleModel.Create(user.getId(), roleId);
                return true;
            } else {
                return false;
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

    public boolean UpdateEmployee(int userId, String password, String email, String phone) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("employee")) {
                String sql = "UPDATE [User] SET password = ?, email = ?, phone = ?, updated_at = ?, updated_by = ? WHERE id = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, password);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                ps.setInt(5, userId);
                ps.setInt(6, userId);
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
        return false;
    }

    public boolean UpdateAdmin(int userId, int target, String password, String email, String phone, int discount_id) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("admin")) {
                String sql = "UPDATE [User] SET password = ?, email = ?, phone = ?, discount_id = ?, updated_at = ?, updated_by = ? WHERE id = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, password);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setInt(4, discount_id);
                ps.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                ps.setInt(6, userId);
                ps.setInt(7, target);
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
        return false;
    }

    public boolean UpdateAvatar(int userId, String link) {
        try {
            UserModel model = new UserModel();
            User user = model.ReadOne(userId);
            AvatarModel avatarModel = new AvatarModel();
            avatarModel.Update(user.getAvatar_id(), link, userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateCustomer(int userId, String phone, int discount_id) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("admin")) {
                String sql = "UPDATE [User] SET discount_id = ?, updated_at = ?, updated_by = ? WHERE phone = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, discount_id);
                ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
                ps.setInt(3, userId);
                ps.setString(4, phone);
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
        return false;
    }

    public User ReadByPhone(String phone) {
        try {
            String sql = "SELECT * FROM [User] WHERE phone = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                String dob = rs.getString("dob");
                if (rs.wasNull()) {
                    user.setDob(null);
                } else {
                    user.setDob(dob);
                }
                String email = rs.getString("email");
                if (rs.wasNull()) {
                    user.setEmail(null);
                } else {
                    user.setEmail(email);
                }
                user.setPhone(rs.getString("phone"));
                int avatarId = rs.getInt("avatar_id");
                if (rs.wasNull()) {
                    user.setAvatar_id(1);
                } else {
                    user.setAvatar_id(avatarId);
                }
                int discountId = rs.getInt("discount_id");
                if (rs.wasNull()) {
                    user.setDiscount_id(1);
                } else {
                    user.setDiscount_id(discountId);
                }
                user.setTotal_contribute(rs.getFloat("total_contribute"));
                Timestamp createdAt = rs.getTimestamp("created_at");
                if (rs.wasNull()) {
                    user.setCreated_at(null);
                } else {
                    user.setCreated_at(createdAt);
                }
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (rs.wasNull()) {
                    user.setUpdated_at(null);
                } else {
                    user.setUpdated_at(updatedAt);
                }
                int createdBy = rs.getInt("created_by");
                if (rs.wasNull()) {
                    user.setCreated_by(1);
                } else {
                    user.setCreated_by(createdBy);
                }
                int updatedBy = rs.getInt("updated_by");
                if (rs.wasNull()) {
                    user.setUpdated_by(1);
                } else {
                    user.setUpdated_by(updatedBy);
                }
                user.setStatus(rs.getBoolean("status"));
                return user;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public boolean UpdateTotalContribute(float totalContribute, int target) {
        try {
            UserModel model = new UserModel();
            User user = model.ReadOne(target);
            totalContribute += user.getTotal_contribute();
            String sql = "UPDATE [User] SET total_contribute = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setFloat(1, totalContribute);
            ps.setInt(2, target);
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

    public boolean UpdateStatus(int userId, int target) {
        try {
            UserModel model = new UserModel();
            if (model.CheckRole(userId).equals("admin")) {
                User user = model.ReadOne(target);
                boolean status = !user.isStatus();
                String sql = "UPDATE [User] SET status = ? WHERE id = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setBoolean(1, status);
                ps.setInt(2, target);
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
        return false;
    }

    public List<EmpManager> ReadForTable() {
        try {
            List<EmpManager> list = new ArrayList<>();
            String active = null;
            String sql = "SELECT username, password, [Role].name AS roll, [User].status FROM [User], [UserRole], [Role] WHERE [User].id = [UserRole].user_id AND [Role].id = [UserRole].role_id";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpManager obj = new EmpManager();
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setRole(rs.getString("roll"));
                if (rs.getBoolean("status") == true) {
                    active = "active";
                } else {
                    active = "inactive";
                }
                obj.setStatus(active);
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

    public boolean UpdateAvatarId(int avatarId, int id) {
        try {
            String sql = "UPDATE [User] SET avatar_id = ? WHERE id = ?";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, avatarId);
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

    public boolean CreateCustomer(int userId, String fullname, String dob, String email, String phone) {
        try {
            String sql = "INSERT INTO [User](fullname,dob,email,phone,discount_id,total_contribute,created_at,created_by,status) VALUES(?,?,?,?,?,?,?,?,?)";
            con = JDBCConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fullname);
            if (dob == null) {
                ps.setString(2, null);
            } else {
                ps.setString(2, dob);
            }
            if (email == null) {
                ps.setString(3, null);
            } else {
                ps.setString(3, email);
            }
            if (phone == null) {
                ps.setString(4, null);
            } else {
                ps.setString(4, phone);
            }
            ps.setInt(5, 1);
            ps.setFloat(6, 0);
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(8, userId);
            ps.setBoolean(9, true);
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

    public boolean UpdateDiscount(int userId) {
        try {
            UserModel model = new UserModel();
            User user = model.ReadOne(userId);            
            if (user.getUsername() == null) {                
                String sql = "UPDATE [User] SET discount_id = ? WHERE id = ?";
                con = JDBCConnect.getConnection();
                ps = con.prepareStatement(sql);
                if (user.getTotal_contribute() >= 0 && user.getTotal_contribute() < 5000000) {
                    ps.setInt(1, 1);
                } else if (user.getTotal_contribute() >= 5000000 && user.getTotal_contribute() < 10000000) {
                    ps.setInt(1, 3);
                } else if (user.getTotal_contribute() >= 10000000 && user.getTotal_contribute() < 15000000){
                    ps.setInt(1, 4);
                } else {
                    ps.setInt(1, 5);
                }
                ps.setInt(2, userId);
                ps.executeUpdate();
                return true;
            } else {
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

    public static void main(String[] args) {
        UserModel model = new UserModel();
        System.out.println(model.UpdateDiscount(3));
    }
}
