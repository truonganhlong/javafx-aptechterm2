/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.CategoryModel;
import BLL.ImageModel;
import BLL.OrderModel;
import BLL.ProductModel;
import DAL.Entity.OrderManager;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class OrderController implements Initializable {

    String username;
    int selectedId;
    int selectedOrder;
    private int pageIndex = 1;
    String selectedCategory = "All";
    Integer tableId;
    float totalPrice = 0;
    List<DAL.Entity.OrderManager> listOrderTable = new ArrayList<>();
    List<DAL.Entity.OrderManager> listOrder = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView lbl_image;
    @FXML
    private TextField txt_pageIndex;
    @FXML
    private Button btn_backpage;
    @FXML
    private Button btn_nextpage;
    @FXML
    private Button btn_searchpage;
    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_search;
    @FXML
    private Label lbl_nameDisplay;
    @FXML
    private Label lbl_quantityDisplay;
    @FXML
    private Label lbl_categoryDisplay;
    @FXML
    private Label lbl_priceDisplay;
    @FXML
    private TableView<DAL.Entity.MenuManager> table_product;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, Integer> idCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, String> nameCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, String> categoryCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, String> unitCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, Float> priceCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, Integer> quantityCol;
    @FXML
    private TableColumn<DAL.Entity.MenuManager, String> statusCol;
    @FXML
    private Label lbl_nameValue1;
    @FXML
    private Label lbl_priceValue1;
    @FXML
    private TextField txt_quantity;
    @FXML
    private TextField txt_note;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_clear;
    @FXML
    private TableView<DAL.Entity.OrderManager> table_order;
    @FXML
    private TableColumn<DAL.Entity.OrderManager, String> nameOrderCol;
    @FXML
    private TableColumn<DAL.Entity.OrderManager, Float> priceOrderCol;
    @FXML
    private TableColumn<DAL.Entity.OrderManager, Integer> quantityOrderCol;
    @FXML
    private TableColumn<DAL.Entity.OrderManager, Float> totalOrderCol;
    @FXML
    private TableColumn<DAL.Entity.OrderManager, String> noteOrderCol;
    @FXML
    private Label lbl_totalPrice;
    @FXML
    private Button btn_later;
    @FXML
    private Button btn_checkOut;
    @FXML
    private ComboBox<String> cbb_category;
    @FXML
    private Button btn_filter;

    ObservableList<DAL.Entity.MenuManager> list1 = FXCollections.observableArrayList();
    ObservableList<DAL.Entity.OrderManager> list2 = FXCollections.observableArrayList();
    @FXML
    private AnchorPane screen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Begin(String username, List<DAL.Entity.OrderManager> listOrderTable) {
        showProduct();
        showCategory();
        this.username = username;
        this.listOrderTable = listOrderTable;
        txt_pageIndex.setText(String.valueOf(pageIndex));
    }

    @FXML
    private void SelectedProduct(MouseEvent event) {
        selectedId = table_product.getSelectionModel().getSelectedIndex();
        lbl_nameDisplay.setText(nameCol.getCellData(selectedId).toString());
        lbl_nameValue1.setText(nameCol.getCellData(selectedId).toString());
        lbl_priceDisplay.setText(priceCol.getCellData(selectedId).toString());
        lbl_priceValue1.setText(priceCol.getCellData(selectedId).toString());
        lbl_quantityDisplay.setText(quantityCol.getCellData(selectedId).toString());
        lbl_categoryDisplay.setText(categoryCol.getCellData(selectedId).toString());
        selectedId = Integer.parseInt(idCol.getCellData(selectedId).toString());        
        showImage(selectedId);
    }

    @FXML
    private void UpdateOrder(ActionEvent event) {
        totalPrice = totalPrice - Float.parseFloat(String.valueOf(totalOrderCol.getCellData(selectedOrder))) + Float.parseFloat(lbl_priceValue1.getText()) * Integer.parseInt(txt_quantity.getText());
        OrderManager obj = listOrder.get(selectedOrder);
        obj.setQuantity(Integer.parseInt(txt_quantity.getText()));
        obj.setTotal(obj.getQuantity() * obj.getPrice());
        showOrder();
    }

    @FXML
    private void DeleteOrder(ActionEvent event) {
        totalPrice = totalPrice - Float.parseFloat(String.valueOf(totalOrderCol.getCellData(selectedOrder)));
        listOrder.remove(selectedOrder);
        showOrder();
    }

    @FXML
    private void AddOrder(ActionEvent event) {
        if (statusCol.getCellData(selectedId -1) == "inactive") {
            JOptionPane.showMessageDialog(null, "This product is inactive, active it to order!");
        } else {
            OrderModel orderModel = new OrderModel();
            list2.clear();
            listOrder.add(orderModel.AddToList(lbl_nameValue1.getText(), Float.parseFloat(lbl_priceValue1.getText()), Integer.parseInt(txt_quantity.getText()), txt_note.getText()));
            totalPrice += Float.parseFloat(lbl_priceValue1.getText()) * Integer.parseInt(txt_quantity.getText());
            list2.addAll(listOrder);
            table_order.setItems(list2);
            nameOrderCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            priceOrderCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            quantityOrderCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            totalOrderCol.setCellValueFactory(new PropertyValueFactory<>("total"));
            noteOrderCol.setCellValueFactory(new PropertyValueFactory<>("note"));
            lbl_totalPrice.setText(String.valueOf(totalPrice));
        }
    }

    @FXML
    private void ClearOrder(ActionEvent event) {
        listOrder.clear();
        totalPrice = 0;
        lbl_totalPrice.setText(String.valueOf(totalPrice));
        showOrder();
    }

    @FXML
    private void SelectedOrder(MouseEvent event) {
        selectedOrder = table_order.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void Later(ActionEvent event) throws IOException {
        if (listOrder.size() == 0) {
            JOptionPane.showMessageDialog(null, "Your orders list is null! Please check again your orders!");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SetTable.fxml"));
            root = loader.load();
            SetTableController ctrl = loader.getController();
            ctrl.Begin(username, listOrder);
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Close(event);
        }
    }

    @FXML
    private void CheckOut(ActionEvent event) throws IOException {
        if (listOrder.size() == 0) {
            JOptionPane.showMessageDialog(null, "Your orders list is null! Please check again your orders!");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchUser.fxml"));
            root = loader.load();
            SearchUserController ctrl = loader.getController();
            System.out.println(listOrderTable);
            if (listOrderTable != null) {
                listOrder.addAll(listOrderTable);
            }
            ctrl.Begin(username, totalPrice, listOrder);
            if (tableId != null) {
                ctrl.TableId(tableId);
            }
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Close(event);
        }
    }

    @FXML
    private void SelectedCategory(ActionEvent event) {
        selectedCategory = cbb_category.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void Filter(ActionEvent event) {
        showProduct();
    }

    private void showProduct() {
        ProductModel productModel = new ProductModel();
        list1.clear();
        if (selectedCategory.equals("All")) {
            list1.addAll(productModel.ReadForTable(pageIndex));
            table_product.setItems(list1);
        } else {
            list1.addAll(productModel.ReadForCategory(pageIndex, selectedCategory));
            table_product.setItems(list1);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    private void BackPage(ActionEvent event) {
        pageIndex = pageIndex - 1;
        txt_pageIndex.setText(String.valueOf(pageIndex));
        Search(event);
    }

    @FXML
    private void NextPage(ActionEvent event) {
        pageIndex = pageIndex + 1;
        txt_pageIndex.setText(String.valueOf(pageIndex));
        Search(event);
    }

    @FXML
    private void SearchIndex(ActionEvent event) {
        pageIndex = Integer.parseInt(txt_pageIndex.getText());
        Search(event);
    }

    private void showCategory() {
        CategoryModel model = new CategoryModel();
        cbb_category.getItems().clear();
        cbb_category.getItems().add("All");
        cbb_category.getItems().addAll(model.ReadName());
        cbb_category.getSelectionModel().select(0);
        selectedCategory = cbb_category.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void Search(ActionEvent event) {
        list1.clear();
        ProductModel productModel = new ProductModel();
        list1.addAll(productModel.SearchName(txt_search.getText(), pageIndex));
        table_product.setItems(list1);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void showImage(int id) {
        ImageModel model = new ImageModel();
        if (!model.Read(id).getLink().isEmpty()) {
            File file = new File(model.Read(id).getLink());
            Image image = new Image(file.toURI().toString());
            lbl_image.setImage(image);
        }
    }

    private void showOrder() {
        list2.clear();
        list2.addAll(listOrder);
        table_order.setItems(list2);
        nameOrderCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceOrderCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityOrderCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalOrderCol.setCellValueFactory(new PropertyValueFactory<>("total"));
        noteOrderCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        lbl_totalPrice.setText(String.valueOf(totalPrice));
    }

    public void TableId(Integer selectedTable) {
        this.tableId = selectedTable;
    }
    
    private void Close(ActionEvent ev) {
        Stage stage = (Stage) screen.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void checkPage(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
        }
    }

    @FXML
    private void checkQuantity(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
        }
    }
}
