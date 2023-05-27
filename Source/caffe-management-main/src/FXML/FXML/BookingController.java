/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.OrderModel;
import BLL.TableModel;
import BLL.UserModel;
import DAL.Entity.Order;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BookingController implements Initializable {

    @FXML
    private Button btn_table10;
    @FXML
    private Button btn_table2;
    @FXML
    private Button btn_table3;
    @FXML
    private Button btn_table4;
    @FXML
    private Button btn_table5;
    @FXML
    private Button btn_table6;
    @FXML
    private Button btn_table7;
    @FXML
    private Button btn_table8;
    @FXML
    private Button btn_table1;
    @FXML
    private Button btn_table9;
    @FXML
    private Button btn_table11;
    @FXML
    private Button btn_table12;
    @FXML
    private Button btn_table13;
    @FXML
    private Button btn_table14;
    @FXML
    private Button btn_table15;
    @FXML
    private Button btn_table16;
    @FXML
    private Button btn_table17;
    @FXML
    private Button btn_table18;
    @FXML
    private Button btn_table19;
    @FXML
    private Button btn_table20;
    @FXML
    private Label lbl_status;
    @FXML
    private Button btn_order;
    @FXML
    private Button btn_checkOut;
    String username;
    int selectedTable;
    float totalPrice = 0;
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

    @FXML
    private void Table10(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(10));
        selectedTable = 10;
    }

    @FXML
    private void Table2(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(2));
        selectedTable = 2;
    }

    @FXML
    private void Table3(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(3));
        selectedTable = 3;
    }

    @FXML
    private void Table4(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(4));
        selectedTable = 4;
    }

    @FXML
    private void Table5(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(5));
        selectedTable = 5;
    }

    @FXML
    private void Table6(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(6));
        selectedTable = 6;
    }

    @FXML
    private void Table7(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(7));
        selectedTable = 7;
    }

    @FXML
    private void Table8(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(8));
        selectedTable = 8;
    }

    @FXML
    private void Table1(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(1));
        selectedTable = 1;
    }

    @FXML
    private void Table9(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(9));
        selectedTable = 9;
    }

    @FXML
    private void Table11(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(11));
        selectedTable = 11;
    }

    @FXML
    private void Table12(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(12));
        selectedTable = 12;
    }

    @FXML
    private void Table13(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(13));
        selectedTable = 13;
    }

    @FXML
    private void Table14(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(14));
        selectedTable = 14;
    }

    @FXML
    private void Table15(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(15));
        selectedTable = 15;
    }

    @FXML
    private void Table16(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(16));
        selectedTable = 16;
    }

    @FXML
    private void Table17(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(17));
        selectedTable = 17;
    }

    @FXML
    private void Table18(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(18));
        selectedTable = 18;
    }

    @FXML
    private void Table19(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(19));
        selectedTable = 19;
    }

    @FXML
    private void Table20(ActionEvent event) {
        TableModel model = new TableModel();
        lbl_status.setText(model.convertStatus(20));
        selectedTable = 20;
    }

    @FXML
    private void Order(ActionEvent event) throws IOException {
        TableModel model = new TableModel();
        OrderModel orderModel = new OrderModel();
        if (lbl_status.getText().equals("Free")) {
            model.UpdateStatusForOrder(selectedTable);
            lbl_status.setText(model.convertStatus(selectedTable));
        } else if(lbl_status.getText().equals("Ordered")){
            model.UpdateStatusForUsing(selectedTable);            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Order.fxml"));
            root = loader.load();
            OrderController ctrl = loader.getController();
            ctrl.Begin(username, null);
            ctrl.TableId(selectedTable);
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } else {            
            System.out.println(orderModel.ConvertOrderManager(orderModel.ReadOrderToPay(selectedTable)));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Order.fxml"));
            root = loader.load();
            OrderController ctrl = loader.getController();
            ctrl.Begin(username, orderModel.ConvertOrderManager(orderModel.ReadOrderToPay(selectedTable)));
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    private void CheckOut(ActionEvent event) {
        try {
            OrderModel orderModel = new OrderModel();
            for(int i = 0; i < orderModel.ReadOrderToPay(selectedTable).size(); i++){
                Order order = orderModel.ReadOrderToPay(selectedTable).get(i);
                totalPrice  += order.getTotal_price();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
            root = loader.load();
            SearchUserController ctrl = loader.getController();
            ctrl.Begin(username, totalPrice, orderModel.ConvertOrderManager(orderModel.ReadOrderToPay(selectedTable)));
            ctrl.TableId(selectedTable);
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Check-out failed!");
        }
    }

    public void Begin(String username) {
        this.username = username;
    }

}
