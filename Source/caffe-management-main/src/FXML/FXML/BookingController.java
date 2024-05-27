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
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane screen;
    @FXML
    private Label lbl_free;
    @FXML
    private Label lbl_ordered;
    @FXML
    private Label lbl_currentlyUse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbl_free.getStyleClass().add("label_free");
        lbl_ordered.getStyleClass().add("label_ordered");
        lbl_currentlyUse.getStyleClass().add("label_currentlyUse");
        TableModel model = new TableModel();
        //table1
        if(model.convertStatus(1).equals("Free")){
            btn_table1.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(1).equals("Ordered")){
            btn_table1.getStyleClass().add("button_primary");
        } else {
            btn_table1.getStyleClass().add("button_success");
        }
        //table2
        if(model.convertStatus(2).equals("Free")){
            btn_table2.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(2).equals("Ordered")){
            btn_table2.getStyleClass().add("button_primary");
        } else {
            btn_table2.getStyleClass().add("button_success");
        }
        //table3
        if(model.convertStatus(3).equals("Free")){
            btn_table3.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(3).equals("Ordered")){
            btn_table3.getStyleClass().add("button_primary");
        } else {
            btn_table3.getStyleClass().add("button_success");
        }
        //table4
        if(model.convertStatus(4).equals("Free")){
            btn_table4.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(4).equals("Ordered")){
            btn_table4.getStyleClass().add("button_primary");
        } else {
            btn_table4.getStyleClass().add("button_success");
        }
        //table5
        if(model.convertStatus(5).equals("Free")){
            btn_table5.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(5).equals("Ordered")){
            btn_table5.getStyleClass().add("button_primary");
        } else {
            btn_table5.getStyleClass().add("button_success");
        }
        //table6
        if(model.convertStatus(6).equals("Free")){
            btn_table6.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(6).equals("Ordered")){
            btn_table6.getStyleClass().add("button_primary");
        } else {
            btn_table6.getStyleClass().add("button_success");
        }
        //table7
        if(model.convertStatus(7).equals("Free")){
            btn_table7.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(7).equals("Ordered")){
            btn_table7.getStyleClass().add("button_primary");
        } else {
            btn_table7.getStyleClass().add("button_success");
        }
        //table8
        if(model.convertStatus(8).equals("Free")){
            btn_table8.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(8).equals("Ordered")){
            btn_table8.getStyleClass().add("button_primary");
        } else {
            btn_table8.getStyleClass().add("button_success");
        }
        //table9
        if(model.convertStatus(9).equals("Free")){
            btn_table9.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(9).equals("Ordered")){
            btn_table9.getStyleClass().add("button_primary");
        } else {
            btn_table9.getStyleClass().add("button_success");
        }
        //table10
        if(model.convertStatus(10).equals("Free")){
            btn_table10.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(10).equals("Ordered")){
            btn_table10.getStyleClass().add("button_primary");
        } else {
            btn_table10.getStyleClass().add("button_success");
        }
        //table11
        if(model.convertStatus(11).equals("Free")){
            btn_table11.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(11).equals("Ordered")){
            btn_table11.getStyleClass().add("button_primary");
        } else {
            btn_table11.getStyleClass().add("button_success");
        }
        //table12
        if(model.convertStatus(12).equals("Free")){
            btn_table12.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(12).equals("Ordered")){
            btn_table12.getStyleClass().add("button_primary");
        } else {
            btn_table12.getStyleClass().add("button_success");
        }
        //table13
        if(model.convertStatus(13).equals("Free")){
            btn_table13.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(13).equals("Ordered")){
            btn_table13.getStyleClass().add("button_primary");
        } else {
            btn_table13.getStyleClass().add("button_success");
        }
        //table14
        if(model.convertStatus(14).equals("Free")){
            btn_table14.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(14).equals("Ordered")){
            btn_table14.getStyleClass().add("button_primary");
        } else {
            btn_table14.getStyleClass().add("button_success");
        }
        //table15
        if(model.convertStatus(15).equals("Free")){
            btn_table15.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(15).equals("Ordered")){
            btn_table15.getStyleClass().add("button_primary");
        } else {
            btn_table15.getStyleClass().add("button_success");
        }
        //table16
        if(model.convertStatus(16).equals("Free")){
            btn_table16.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(16).equals("Ordered")){
            btn_table16.getStyleClass().add("button_primary");
        } else {
            btn_table16.getStyleClass().add("button_success");
        }
        //table17
        if(model.convertStatus(17).equals("Free")){
            btn_table17.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(17).equals("Ordered")){
            btn_table17.getStyleClass().add("button_primary");
        } else {
            btn_table17.getStyleClass().add("button_success");
        }
        //table18
        if(model.convertStatus(18).equals("Free")){
            btn_table18.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(18).equals("Ordered")){
            btn_table18.getStyleClass().add("button_primary");
        } else {
            btn_table18.getStyleClass().add("button_success");
        }
        //table19
        if(model.convertStatus(19).equals("Free")){
            btn_table19.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(19).equals("Ordered")){
            btn_table19.getStyleClass().add("button_primary");
        } else {
            btn_table19.getStyleClass().add("button_success");
        }
        //table20
        if(model.convertStatus(20).equals("Free")){
            btn_table20.getStyleClass().add("button_deffault");
        } else if(model.convertStatus(20).equals("Ordered")){
            btn_table20.getStyleClass().add("button_primary");
        } else {
            btn_table20.getStyleClass().add("button_success");
        }
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
            Close(event);
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
            Close(event);
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
            Close(event);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Check-out failed!");
            Close(event);
        }
    }

    public void Begin(String username) {
        this.username = username;
    }

    private void Close(ActionEvent ev) {
        Stage stage = (Stage) screen.getScene().getWindow();
        stage.close();
    }
}
