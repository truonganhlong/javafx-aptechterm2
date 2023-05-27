/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.DiscountModel;
import BLL.OrderModel;
import BLL.ProductModel;
import BLL.TableModel;
import BLL.UserModel;
import DAL.Entity.OrderManager;
import DAL.Entity.User;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SearchUserController implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_search;
    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_phone;
    @FXML
    private Label lbl_discountValue;
    @FXML
    private Label lbl_totalContributeValue;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_order;
    @FXML
    private DatePicker txt_dob;

    String username;
    float value = 1;
    float totalPrice;
    Integer tableId;
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
    private void Search(ActionEvent event) {
        try {
            UserModel model = new UserModel();
            DiscountModel discountModel = new DiscountModel();
            User user = model.ReadByPhone(txt_search.getText());
            System.out.println(user);
            txt_fullname.setText(user.getFullname());
            if (user.getDob() != null) {
                LocalDate date = LocalDate.parse(user.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                txt_dob.setValue(date);
            }
            if (user.getEmail() != null) {
                txt_email.setText(user.getEmail());
            }
            if (user.getPhone() != null) {
                txt_phone.setText(user.getPhone());
            }
            lbl_discountValue.setText(discountModel.ReadOne(user.getDiscount_id()).getName());
            value = discountModel.ReadOne(user.getDiscount_id()).getValue();
            lbl_totalContributeValue.setText(String.valueOf(user.getTotal_contribute()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cant find any user!");
        }
    }

    @FXML
    private void Create(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to create this user?", "CREATE", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                UserModel model = new UserModel();
                LocalDate myDate = txt_dob.getValue();
                String date = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                model.CreateCustomer(model.Login(username).getId(), txt_fullname.getText(), date, txt_email.getText(), txt_phone.getText());
                JOptionPane.showMessageDialog(null, "Create success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Create failed!");
            }
        }
    }

    @FXML
    private void Order(ActionEvent event) {        
        DiscountModel discountModel = new DiscountModel();
        if(!lbl_discountValue.getText().isEmpty()){
            totalPrice = totalPrice * discountModel.ReadName(lbl_discountValue.getText()).getValue();
        }
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure this user? Your bill is " + totalPrice, "CHECK OUT", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                OrderModel model = new OrderModel();
                UserModel userModel = new UserModel();
                ProductModel productModel = new ProductModel();
                if (lbl_discountValue.getText().isEmpty()) {
                    System.out.println(lbl_discountValue.getText());
                    if (tableId == null) {
                        for (int i = 0; i < listOrder.size(); i++) {
                            OrderManager obj = listOrder.get(i);
                            model.CreateOrder(null, userModel.ReadName(username).getId(), productModel.ReadName(obj.getName()), obj.getQuantity(), obj.getNote(), null, true, 1);
                        }
                    } else {
                        System.out.println("test2");
                        model.UpdateOrderPayLater(null, tableId);
                        //change status
                        TableModel tableModel = new TableModel();
                        tableModel.UpdateStatusForFree(tableId);
                    }
                } else {
                    if (tableId == null) {
                        for (int i = 0; i < listOrder.size(); i++) {
                            OrderManager obj = listOrder.get(i);
                            model.CreateOrder(userModel.ReadByPhone(txt_search.getText()).getId(), userModel.ReadName(username).getId(), productModel.ReadName(obj.getName()), obj.getQuantity(), obj.getNote(), null, true, 1);                            
                        }                                                
                    } else {
                        System.out.println("test2");
                        model.UpdateOrderPayLater(userModel.ReadByPhone(txt_search.getText()).getId(), tableId);                        
                        //change status
                        TableModel tableModel = new TableModel();
                        tableModel.UpdateStatusForFree(tableId);
                    }
                    userModel.UpdateTotalContribute(totalPrice, userModel.ReadByPhone(txt_search.getText()).getId());
                    userModel.UpdateDiscount(userModel.ReadByPhone(txt_search.getText()).getId());
                }
                JOptionPane.showMessageDialog(null, "Check-out success!");
                Close(event);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Check-out failed!");
            }
        }
    }

    public void Begin(String username, float totalPrice, List<OrderManager> listOrder) {
        this.username = username;
        this.totalPrice = totalPrice;
        this.listOrder = listOrder;
    }

    private void Close(ActionEvent ev) {
        Stage stage = (Stage) scene.getScene().getWindow();
        stage.close();
    }

    public void TableId(Integer tableId) {
        this.tableId = tableId;
    }
}
