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
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ProfileForAdminController implements Initializable {

    String username;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String selectedDiscount;
    private String linkAvatar;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_avatar;
    @FXML
    private PasswordField txt_password;
    @FXML
    private ComboBox<String> cbb_discount;
    @FXML
    private Label lbl_contributeValue;
    @FXML
    private TextField txt_phone;
    @FXML
    private Label lbl_dobValue;
    @FXML
    private Label lbl_fullnameValue;
    @FXML
    private Label lbl_usernameValue;
    @FXML
    private Button btn_browse;
    @FXML
    private ImageView lbl_image;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_update;
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
    private Label lbl_role;
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
        lbl_usernameValue.setText(username);
        showComboData();
        UserModel userModel = new UserModel();
        User user = userModel.ReadName(username);
        lbl_role.setText("Role: " + userModel.CheckRole(user.getId()));
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
        AvatarModel avatarModel = new AvatarModel();
        if (user.getAvatar_id() == 0) {
            txt_avatar.setText(null);
        } else {
            txt_avatar.setText(avatarModel.CheckAvatar(user.getAvatar_id()));
            linkAvatar = txt_avatar.getText();
            System.out.println(linkAvatar);
        }
        lbl_contributeValue.setText(String.valueOf(user.getTotal_contribute()));
        showAvatar();
    }

    public void showComboData() {
        DiscountModel model = new DiscountModel();
        UserModel userModel = new UserModel();
        User user = userModel.ReadName(lbl_usernameValue.getText());
        cbb_discount.getItems().clear();
        cbb_discount.getItems().addAll(model.ReadValue(user.getDiscount_id()));
        cbb_discount.getSelectionModel().select(0);
        selectedDiscount = cbb_discount.getSelectionModel().getSelectedItem();
    }

    private void showAvatar() {
        File file = new File(txt_avatar.getText());
        Image image = new Image(file.toURI().toString());
        lbl_image.setImage(image);
    }

    @FXML
    public void Browse(ActionEvent ev) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        String filename = file.getAbsolutePath();
        txt_avatar.setText(filename);
        Image image = new Image(file.toURI().toString());
        lbl_image.setImage(image);
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

    @FXML
    private void Save(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to save this image ?", "Save", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel model = new UserModel();
                if(linkAvatar.equals("H:\\\\ImageForCaffeManagement\\\\Screenshot 2022-11-27 153113.png")){                    
                    AvatarModel avatarModel = new AvatarModel();
                    int id = avatarModel.Create(txt_avatar.getText(),model.ReadName(lbl_usernameValue.getText()).getId());
                    model.UpdateAvatarId(id, model.ReadName(lbl_usernameValue.getText()).getId());
                }
                else {
                    model.UpdateAvatar(model.ReadName(lbl_usernameValue.getText()).getId(), txt_avatar.getText());
                }                                
                JOptionPane.showMessageDialog(null, "Save success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Save failed!");
            }
        }
    }

    @FXML
    private void Update(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to update ?", "Update", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel userModel = new UserModel();
                User user = userModel.ReadName(lbl_usernameValue.getText());
                DiscountModel discountModel = new DiscountModel();
                userModel.UpdateAdmin(user.getId(), user.getId(), txt_password.getText(), txt_email.getText(), txt_phone.getText(), discountModel.ReadId(selectedDiscount));
                JOptionPane.showMessageDialog(null, "Update success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
        }
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
