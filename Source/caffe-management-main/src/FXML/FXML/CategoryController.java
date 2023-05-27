/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.CategoryModel;
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
public class CategoryController implements Initializable {

    @FXML
    private TableView<DAL.Entity.Category> table_category;
    @FXML
    private TableColumn<DAL.Entity.Category, Integer> idCol;
    @FXML
    private TableColumn<DAL.Entity.Category, String> nameCol;
    @FXML
    private TableColumn<DAL.Entity.Category, Boolean> statusCol;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_onOff;
    @FXML
    private TextField txt_name;
    int selectedId;
    ObservableList<DAL.Entity.Category> list = FXCollections.observableArrayList();
    String username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Begin(String username) {
        this.username = username;
        showCategory();
    }

    @FXML
    private void SelectedId(MouseEvent event) {
        selectedId = table_category.getSelectionModel().getSelectedIndex();
        txt_name.setText(nameCol.getCellData(selectedId).toString());
        selectedId = Integer.parseInt(idCol.getCellData(selectedId).toString());
    }

    @FXML
    private void Create(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to create this category?", "Create", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                CategoryModel model = new CategoryModel();
                UserModel userModel = new UserModel();
                model.Create(txt_name.getText(), userModel.ReadName(username).getId());
                showCategory();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something wrong, please try again!");
            }
        }
    }

    @FXML
    private void Update(ActionEvent event) {
        CategoryModel model = new CategoryModel();
        UserModel userModel = new UserModel();
        model.Update(txt_name.getText(), userModel.ReadName(username).getId(), selectedId);
        showCategory();
    }

    @FXML
    private void OnOff(ActionEvent event) {
        CategoryModel model = new CategoryModel();
        UserModel userModel = new UserModel();
        model.UpdateStatus(userModel.ReadName(username).getId(), selectedId);
        showCategory();
    }

    private void showCategory() {
        CategoryModel model = new CategoryModel();
        list.clear();
        list.addAll(model.ReadAll());
        table_category.setItems(list);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
}
