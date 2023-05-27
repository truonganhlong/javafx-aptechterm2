/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;


import BLL.UserModel;
import DAL.Entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Button btn_login;
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
    
    public void Login(ActionEvent event) throws IOException{
        UserModel model = new UserModel();
        if (model.Login(txt_username.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Cant find this username");
        } else {
            User user = model.Login(txt_username.getText());            
            if(!user.getPassword().equals(txt_password.getText())){
                JOptionPane.showMessageDialog(null, "Wrong password");
            }
            else{
                if(model.CheckRole(user.getId()).equals("admin")){                                                          
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeForAdmin.fxml"));
                    root = loader.load();
                    HomeForAdminController ctrl = loader.getController();
                    ctrl.Begin(txt_username.getText());
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
                else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeForEmployee.fxml"));
                    root = loader.load();
                    HomeForEmployeeController ctrl = loader.getController();
                    ctrl.Begin(txt_username.getText());
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                }
            }
        }
    }
}
