/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.DiscountModel;
import BLL.RoleModel;
import BLL.UserModel;
import DAL.Entity.User;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CreateUserController implements Initializable {

    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_phone;
    @FXML
    private PasswordField txt_password;
    @FXML
    private DatePicker txt_dob;
    @FXML
    private ComboBox<String> cbb_discount;
    @FXML
    private ComboBox<String> cbb_role;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_singout;
    @FXML
    private Button btn_booking;
    @FXML
    private Button btn_employee;
    @FXML
    private Button btn_menuManager;
    @FXML
    private Button btn_profile;
    @FXML
    private Button btn_order;
    @FXML
    private Button btn_home;
    String username;
    String selectedDiscount;
    String selectedRole;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void Begin(String username){
        this.username = username;
        showComboData();
    }
    @FXML
    private void Create(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to create this user?", "CREATE", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel model = new UserModel();
                RoleModel roleModel = new RoleModel();
                LocalDate myDate = txt_dob.getValue();                 
                String date = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));                
                model.Create(model.ReadName(username).getId(), roleModel.CheckRoleId(selectedRole), txt_username.getText(), txt_password.getText(), txt_fullname.getText(), date, txt_email.getText(), txt_phone.getText());
                JOptionPane.showMessageDialog(null, "Create success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Create failed!");
            }
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmpManager.fxml"));
        root = loader.load();
        EmpManagerController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Signout(ActionEvent event) throws IOException {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    private void Booking(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
        root = loader.load();
        BookingController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Employee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmpManager.fxml"));
        root = loader.load();
        EmpManagerController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void MenuManager(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuManager.fxml"));
        root = loader.load();
        MenuManagerController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileForAdmin.fxml"));
        root = loader.load();
        ProfileForAdminController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Order(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Order.fxml"));
        root = loader.load();
        OrderController ctrl = loader.getController();
        ctrl.Begin(username, null);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeForAdmin.fxml"));
        root = loader.load();
        HomeForAdminController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    public void showComboData() {
        DiscountModel discountModel = new DiscountModel();
        RoleModel roleModel = new RoleModel();
        UserModel userModel = new UserModel();
        User user = userModel.ReadName(username);
        cbb_discount.getItems().clear();
        cbb_discount.getItems().addAll(discountModel.ReadValue(user.getDiscount_id()));
        cbb_discount.getSelectionModel().select(0);
        selectedDiscount = cbb_discount.getSelectionModel().getSelectedItem();
        cbb_role.getItems().clear();
        cbb_role.getItems().addAll(roleModel.ReadName());
        cbb_role.getSelectionModel().select(0);
        selectedRole = cbb_role.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void SelectedDiscount(ActionEvent event) {
        selectedDiscount = cbb_discount.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void SelectedRole(ActionEvent event) {
        selectedRole = cbb_role.getSelectionModel().getSelectedItem();
    }
}
