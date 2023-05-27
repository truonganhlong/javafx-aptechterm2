/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.AvatarModel;
import BLL.CategoryModel;
import BLL.ImageModel;
import BLL.ProductModel;
import BLL.UnitModel;
import BLL.UserModel;
import DAL.Entity.Product;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MenuManagerController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int pageIndex = 1;
    private String username;
    String selectedCategory;
    String selectedUnit;
    String selectedStatus = "ALL";
    int selectedId;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_quantity;
    @FXML
    private ComboBox<String> cbb_category;
    @FXML
    private ComboBox<String> cbb_unit;
    @FXML
    private ComboBox<String> cbb_status;
    @FXML
    private Label lbl_statusValue;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_updateStatus;
    @FXML
    private TextField txt_pageIndex;
    @FXML
    private Button btn_backpage;
    @FXML
    private Button btn_nextpage;
    @FXML
    private Button btn_searchpage;
    @FXML
    private ImageView lbl_image;
    @FXML
    private TextField txt_image;
    @FXML
    private Button btn_browse;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_category;
    @FXML
    private Button btn_addQuantity;
    @FXML
    private Button btn_unit;
    @FXML
    private Button btn_back;
    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_search;
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
    private Button btn_filter;
    @FXML
    private Button btn_home;
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
    ObservableList<DAL.Entity.MenuManager> list = FXCollections.observableArrayList();
    @FXML
    private Button btn_data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showProduct();
    }

    public void Begin(String username) {

        this.username = username;
        txt_pageIndex.setText(String.valueOf(pageIndex));
        showCategoryData(1);
        showUnitData(1);
        String statuses[] = {"ALL", "ACTIVE", "INACTIVE"};
        cbb_status.setItems(FXCollections.observableArrayList(statuses));
        cbb_status.getSelectionModel().select(0);
    }

    @FXML
    private void Create(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to create this product?", "Create", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                ProductModel model = new ProductModel();
                CategoryModel categoryModel = new CategoryModel();
                UnitModel unitModel = new UnitModel();
                UserModel userModel = new UserModel();
                if (txt_quantity.getText().isEmpty()) {
                    model.Create(txt_name.getText(), categoryModel.ReadId(selectedCategory), unitModel.ReadId(selectedUnit), Float.parseFloat(txt_price.getText()), null, userModel.ReadName(username).getId());
                } else {
                    model.Create(txt_name.getText(), categoryModel.ReadId(selectedCategory), unitModel.ReadId(selectedUnit), Float.parseFloat(txt_price.getText()), Integer.parseInt(txt_quantity.getText()), userModel.ReadName(username).getId());
                }
                JOptionPane.showMessageDialog(null, "Create success!");
                showProduct();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Create failed!");
            }
        }
    }

    @FXML
    private void Update(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to update this product?", "Update", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                ProductModel model = new ProductModel();
                CategoryModel categoryModel = new CategoryModel();
                UnitModel unitModel = new UnitModel();
                UserModel userModel = new UserModel();
                if (txt_quantity.getText().isEmpty()) {
                    model.Update(txt_name.getText(), categoryModel.ReadId(selectedCategory), unitModel.ReadId(selectedUnit), Float.parseFloat(txt_price.getText()), null, userModel.ReadName(username).getId(), selectedId);
                } else {
                    model.Update(txt_name.getText(), categoryModel.ReadId(selectedCategory), unitModel.ReadId(selectedUnit), Float.parseFloat(txt_price.getText()), Integer.parseInt(txt_price.getText()), userModel.ReadName(username).getId(), selectedId);
                }
                JOptionPane.showMessageDialog(null, "Update success!");
                showProduct();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
        }
    }

    @FXML
    private void UpdateStatus(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to update this product?", "Update", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                ProductModel model = new ProductModel();
                model.UpdateStatus(selectedId);
                JOptionPane.showMessageDialog(null, "Update success!");
                showProduct();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
        }
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

    @FXML
    private void Browse(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        String filename = file.getAbsolutePath();
        txt_image.setText(filename);
        Image image = new Image(file.toURI().toString());
        lbl_image.setImage(image);
    }

    @FXML
    private void Save(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to save this image ?", "Save", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                ImageModel model = new ImageModel();
                UserModel userModel = new UserModel();
                if (model.Read(selectedId) == null) {
                    model.Create(selectedId, txt_image.getText(), userModel.ReadName(username).getId());
                } else {
                    model.Update(selectedId, txt_image.getText(), userModel.ReadName(username).getId());
                }
                JOptionPane.showMessageDialog(null, "Save success!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Save failed!");
            }
        }
    }

    @FXML
    private void Category(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Category.fxml"));
        root = loader.load();
        CategoryController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void AddQuantity(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure to add quantity ?", "Add Quantity", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                ProductModel model = new ProductModel();
                model.AddQuantity(selectedId, Integer.parseInt(txt_quantity.getText()));
                JOptionPane.showMessageDialog(null, "Add success!");
                showProduct();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Add failed!");
            }
        }
    }

    @FXML
    private void Unit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Unit.fxml"));
        root = loader.load();
        UnitController ctrl = loader.getController();
        ctrl.Begin(username);
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
    private void Search(ActionEvent event) {
        ProductModel productModel = new ProductModel();
        list.clear();
        list.addAll(productModel.SearchName(txt_search.getText(), pageIndex));
        table_product.setItems(list);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
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

    @FXML
    private void Filter(ActionEvent event) {
        showProduct();
    }

    private void showProduct() {
        ProductModel productModel = new ProductModel();
        list.clear();                       
        if (selectedStatus.equals("ALL")) {
            list.addAll(productModel.ReadForTable(pageIndex));
            table_product.setItems(list);
        } else if (selectedStatus.equals("ACTIVE")) {
            list.addAll(productModel.ReadForStatus(true, pageIndex));
            table_product.setItems(list);
        } else {
            list.addAll(productModel.ReadForStatus(false, pageIndex));
            table_product.setItems((list));
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void showCategoryData(int id) {
        CategoryModel model = new CategoryModel();
        ProductModel productModel = new ProductModel();
        Product product = productModel.ReadOne(id);
        cbb_category.getItems().clear();
        cbb_category.getItems().addAll(model.ReadValue(product.getCategory_id()));
        cbb_category.getSelectionModel().select(0);
        selectedCategory = cbb_category.getSelectionModel().getSelectedItem();
    }

    private void showUnitData(int id) {
        UnitModel model = new UnitModel();
        ProductModel productModel = new ProductModel();
        Product product = productModel.ReadOne(id);
        cbb_unit.getItems().clear();
        cbb_unit.getItems().addAll(model.ReadValue(product.getUnit_id()));
        cbb_unit.getSelectionModel().select(0);
        selectedUnit = cbb_unit.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void SelectedCategory(ActionEvent event) {
        selectedCategory = cbb_category.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void SelectedUnit(ActionEvent event) {
        selectedUnit = cbb_unit.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void SelectedStatus(ActionEvent event) {
        selectedStatus = cbb_status.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void GetItem(MouseEvent event) {        
        selectedId = table_product.getSelectionModel().getSelectedIndex();
        //System.out.println(selectedId);
        txt_name.setText(nameCol.getCellData(selectedId).toString());
        txt_price.setText(priceCol.getCellData(selectedId).toString());
        txt_quantity.setText(quantityCol.getCellData(selectedId).toString());
        selectedId = Integer.parseInt(idCol.getCellData(selectedId).toString());
        showCategoryData(selectedId);
        showUnitData(selectedId);
        //System.out.println(statusCol.getCellData(selectedId).toString());
        lbl_statusValue.setText(statusCol.getCellData(selectedId).toString());
        showImage(selectedId);
        //System.out.println(selectedId);
    }

    private void showImage(int id) {
        ImageModel model = new ImageModel();
        if (!model.Read(id).getLink().isEmpty()) {
            txt_image.setText(model.Read(id).getLink());
            File file = new File(txt_image.getText());
            Image image = new Image(file.toURI().toString());
            lbl_image.setImage(image);
        }
        
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
