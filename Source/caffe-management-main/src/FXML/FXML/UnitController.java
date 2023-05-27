/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.UnitModel;
import BLL.UserModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class UnitController implements Initializable {

    String username;
    @FXML
    private TableView<DAL.Entity.Unit> table_unit;
    @FXML
    private TableColumn<DAL.Entity.Unit, Integer> idCol;
    @FXML
    private TableColumn<DAL.Entity.Unit, String> nameCol;
    @FXML
    private TableColumn<DAL.Entity.Unit, Boolean> statusCol;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_onOff;
    @FXML
    private TextField txt_name;
    int selectedId;
    ObservableList<DAL.Entity.Unit> list = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Begin(String username) {
        this.username = username;
        showUnit();
    }

    @FXML
    private void SelectedId(MouseEvent event) {
        selectedId = table_unit.getSelectionModel().getSelectedIndex();
        txt_name.setText(nameCol.getCellData(selectedId).toString());
        selectedId = Integer.parseInt(idCol.getCellData(selectedId).toString());
    }

    @FXML
    private void Create(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to create this category?", "Create", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UnitModel model = new UnitModel();
                UserModel userModel = new UserModel();
                model.Create(txt_name.getText(), userModel.ReadName(username).getId());
                showUnit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something wrong, please try again!");
            }
        }
    }

    @FXML
    private void Update(ActionEvent event) {
        UnitModel model = new UnitModel();
        UserModel userModel = new UserModel();
        model.Update(txt_name.getText(), userModel.ReadName(username).getId(), selectedId);
        showUnit();
    }

    @FXML
    private void OnOff(ActionEvent event) {
        UnitModel model = new UnitModel();
        UserModel userModel = new UserModel();
        model.UpdateStatus(userModel.ReadName(username).getId(), selectedId);
        showUnit();
    }
    
    private void showUnit(){
        UnitModel model = new UnitModel();
        list.clear();
        list.addAll(model.ReadAll());
        table_unit.setItems(list);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
}
