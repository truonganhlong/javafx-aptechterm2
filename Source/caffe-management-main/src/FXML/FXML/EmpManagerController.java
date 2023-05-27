/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.AvatarModel;
import BLL.DiscountModel;
import BLL.UserModel;
import DAL.Entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class EmpManagerController implements Initializable {

    String username;
    String selectedDiscount;
    int selectedId;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_password;
    @FXML
    private ComboBox<String> cbb_discount;
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
    private Label lbl_contributeValue;
    @FXML
    private TextField txt_phone;
    @FXML
    private Label lbl_statusValue;
    @FXML
    private Label lbl_usernameValue;
    @FXML
    private Label lbl_fullnameValue;
    @FXML
    private Label lbl_dobValue;
    @FXML
    private TableView<DAL.Entity.EmpManager> table_user;
    @FXML
    private TableColumn<DAL.Entity.EmpManager, String> usernameCol;
    @FXML
    private TableColumn<DAL.Entity.EmpManager, String> passwordCol;
    @FXML
    private TableColumn<DAL.Entity.EmpManager, String> roleCol;
    @FXML
    private TableColumn<DAL.Entity.EmpManager, String> statusCol;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_on_off;
    @FXML
    private Button btn_home;
    @FXML
    private Button btn_data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Begin(String username) {
        this.username = username;
        showUser();
        btn_on_off.setVisible(false);
    }

    @FXML
    private void SelectedUser(MouseEvent event) {
        btn_on_off.setVisible(true);
        selectedId = table_user.getSelectionModel().getSelectedIndex();
        UserModel userModel = new UserModel();
        User user = userModel.ReadName(usernameCol.getCellData(selectedId).toString());
        lbl_usernameValue.setText(user.getUsername());
        txt_password.setText(user.getPassword());
        txt_password.setText(user.getPassword());
        lbl_fullnameValue.setText(user.getFullname());
        if (user.getDob() == null) {
            lbl_dobValue.setText(null);
        } else {
            lbl_dobValue.setText(user.getDob().toString());
        }
        if (user.getEmail() == null) {
            txt_email.setText(null);
        } else {
            txt_email.setText(user.getEmail());
        }
        if (user.getPhone() == null) {
            txt_phone.setText(null);
        } else {
            txt_phone.setText(user.getPhone());
        }        
        lbl_contributeValue.setText(String.valueOf(user.getTotal_contribute()));
        lbl_statusValue.setText(statusCol.getCellData(selectedId).toString());
        showComboData();
        if (lbl_statusValue.getText().equals("active")) {
            btn_on_off.setText("INACTIVE");
        } else {
            btn_on_off.setText("ACTIVE");
        }
        
    }

    @FXML
    private void Create(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
        root = loader.load();
        CreateUserController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
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

    @FXML
    private void Update(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to update this user?", "Update", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel userModel = new UserModel();
                DiscountModel discountModel = new DiscountModel();
                userModel.UpdateAdmin(userModel.ReadName(username).getId(), userModel.ReadName(lbl_usernameValue.getText()).getId(), txt_password.getText(), txt_email.getText(), txt_phone.getText(), discountModel.ReadId(selectedDiscount));
                JOptionPane.showMessageDialog(null, "Update success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
        }
    }

    @FXML
    private void OnOff(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to update status this user?", "Update status", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel model = new UserModel();
                model.UpdateStatus(model.ReadName(username).getId(), model.ReadName(lbl_usernameValue.getText()).getId());
                JOptionPane.showMessageDialog(null, "Update success!");
                showUser();
                if(lbl_statusValue.getText().equals("active")){
                    lbl_statusValue.setText("inactive");
                    btn_on_off.setText("INACTIVE");
                }
                else {
                    lbl_statusValue.setText("active");
                    btn_on_off.setText("ACTIVE");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
        }
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
        ctrl.Begin(lbl_fullnameValue.getText());
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
        ctrl.Begin(lbl_fullnameValue.getText());
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
        ctrl.Begin(lbl_fullnameValue.getText());
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
        ctrl.Begin(lbl_fullnameValue.getText(), null);
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

    private void showUser() {
        UserModel model = new UserModel();
        ObservableList<DAL.Entity.EmpManager> list = FXCollections.observableArrayList(model.ReadForTable());
        table_user.setItems(list);
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));        
    }
    
    private void showComboData() {
        DiscountModel model = new DiscountModel();
        UserModel userModel = new UserModel();
        User user = userModel.ReadName(lbl_usernameValue.getText());
        cbb_discount.getItems().clear();
        cbb_discount.getItems().addAll(model.ReadValue(user.getDiscount_id()));
        cbb_discount.getSelectionModel().select(0);
        selectedDiscount = cbb_discount.getSelectionModel().getSelectedItem();        
    }

    @FXML
    private void SelectedDiscount(ActionEvent event) {
        selectedDiscount = cbb_discount.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void Data(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Data.fxml"));
        root = loader.load();
        DataController ctrl = loader.getController();    
        ctrl.Begin(username);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
