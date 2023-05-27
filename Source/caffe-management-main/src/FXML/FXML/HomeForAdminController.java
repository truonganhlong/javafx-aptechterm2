/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HomeForAdminController implements Initializable {

    String username;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btn_singout;
    @FXML
    private Button btn_booking;
    @FXML
    private Button btn_profile;
    @FXML
    private Button btn_order;
    @FXML
    private Button btn_employee;
    @FXML
    private Button btn_menuManager;
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
    
    public void Begin(String username){
        this.username = username;
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
