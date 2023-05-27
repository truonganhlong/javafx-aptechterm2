/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.OrderModel;
import BLL.ProductModel;
import BLL.TableModel;
import BLL.UserModel;
import DAL.Entity.OrderManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SetTableController implements Initializable {

    @FXML
    private AnchorPane pane1;
    @FXML
    private ComboBox<String> cbb_table1;
    @FXML
    private CheckBox checkbox;
    @FXML
    private AnchorPane pane2;
    @FXML
    private ComboBox<String> cbb_table2;
    @FXML
    private Button btn_order;
    String username;
    String selectedTable;
    List<OrderManager> listOrder = new ArrayList<>();
    @FXML
    private AnchorPane scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SelectedTable1(ActionEvent event) {
        selectedTable = cbb_table1.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void CheckOption(ActionEvent event) {
        if (checkbox.isSelected()) {
            pane1.setVisible(false);
            pane2.setVisible(true);
            showData2();
        } else {
            pane1.setVisible(true);
            pane2.setVisible(false);
            showData1();
        }
    }

    @FXML
    private void SelectedTable2(ActionEvent event) {
        selectedTable = cbb_table2.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void Order(ActionEvent event) {
        try {
            TableModel tableModel = new TableModel();
            OrderModel orderModel = new OrderModel();
            UserModel userModel = new UserModel();
            ProductModel productModel = new ProductModel();
            if (pane1.isVisible()) {
                for (int i = 0; i < listOrder.size(); i++) {
                    OrderManager obj = listOrder.get(i);
                    orderModel.CreateOrder(null, userModel.ReadName(username).getId(), productModel.ReadName(obj.getName()), obj.getQuantity(), obj.getNote(), tableModel.ReadOne(selectedTable).getId(), false, 0);
                }
                tableModel.UpdateStatusForUsing(tableModel.ReadOne(selectedTable).getId());
            } else {
                for (int i = 0; i < listOrder.size(); i++) {
                    OrderManager obj = listOrder.get(i);
                    orderModel.CreateOrder(null, userModel.ReadName(username).getId(), productModel.ReadName(obj.getName()), obj.getQuantity(), obj.getNote(), tableModel.ReadOne(selectedTable).getId(), false, 0);
                }                
            }
            JOptionPane.showMessageDialog(null, "Order success!");
            Close(event);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Order failed!");
        }
    }

    public void Begin(String username, List<OrderManager> listOrder) {
        this.username = username;
        this.listOrder = listOrder;
        showData1();
        pane2.setVisible(false);
    }

    private void showData1() {
        TableModel model = new TableModel();
        cbb_table1.getItems().clear();
        cbb_table1.getItems().addAll(model.ReadFree());
        cbb_table1.getSelectionModel().select(0);
        selectedTable = cbb_table1.getSelectionModel().getSelectedItem();
    }

    private void showData2() {
        TableModel model = new TableModel();
        cbb_table2.getItems().clear();
        cbb_table2.getItems().addAll(model.ReadUse());
        cbb_table2.getSelectionModel().select(0);
        selectedTable = cbb_table2.getSelectionModel().getSelectedItem();
    }

    private void Close(ActionEvent ev) {
        Stage stage = (Stage) scene.getScene().getWindow();
        stage.close();
    }
}
