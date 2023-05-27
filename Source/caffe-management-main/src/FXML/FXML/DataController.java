/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML.FXML;

import BLL.OrderModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DataController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private LineChart<String, Float> linechart;
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
    private Button btn_home;
    @FXML
    private Button btn_data;
    @FXML
    private Button btn_search;
    @FXML
    private TableView<DAL.Entity.DataManager> table_order;
    @FXML
    private TableColumn<DAL.Entity.DataManager, String> productCol;
    @FXML
    private TableColumn<DAL.Entity.DataManager, Integer> quantityCol;
    @FXML
    private TableColumn<DAL.Entity.DataManager, Float> totalPriceCol;
    @FXML
    private TableColumn<DAL.Entity.DataManager, Timestamp> timeCol;
    @FXML
    private Button btn_load;
    private String username;
    @FXML
    private TableColumn<DAL.Entity.DataManager, String> orderByCol;
    ObservableList<DAL.Entity.DataManager> list = FXCollections.observableArrayList();
    @FXML
    private DatePicker txt_begin;
    @FXML
    private DatePicker txt_end;

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

    @FXML
    private void Search(ActionEvent event) {
        OrderModel model = new OrderModel();
        LocalDate begin = txt_begin.getValue();
        String beginDate = begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(beginDate);
        LocalDate end = txt_end.getValue();
        String endDate = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(endDate);
        list.addAll(model.ReadOrderData(beginDate, endDate));
        System.out.println(list);
        table_order.setItems(list);
        productCol.setCellValueFactory(new PropertyValueFactory<>("product"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        orderByCol.setCellValueFactory(new PropertyValueFactory<>("orderBy"));
    }

    @FXML
    private void Load(ActionEvent event) {
        OrderModel model = new OrderModel();
        LocalDate date = java.time.LocalDate.now();
        linechart.getData().clear();
        XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
        series.getData().add(new XYChart.Data<String, Float>("Day 1", model.totalPriceForChart(date.minusDays(6).toString(), date.minusDays(5).toString())));
        series.getData().add(new XYChart.Data<String, Float>("Day 2", model.totalPriceForChart(date.minusDays(5).toString(), date.minusDays(4).toString())));
        series.getData().add(new XYChart.Data<String, Float>("Day 3", model.totalPriceForChart(date.minusDays(4).toString(), date.minusDays(3).toString())));
        series.getData().add(new XYChart.Data<String, Float>("Day 4", model.totalPriceForChart(date.minusDays(3).toString(), date.minusDays(2).toString())));
        series.getData().add(new XYChart.Data<String, Float>("Day 5", model.totalPriceForChart(date.minusDays(2).toString(), date.minusDays(1).toString())));
        series.getData().add(new XYChart.Data<String, Float>("Day 6", model.totalPriceForChart(date.minusDays(1).toString(), date.toString())));
        series.getData().add(new XYChart.Data<String, Float>("Today", model.totalPriceForChart(date.toString(), date.plusDays(1).toString())));
        series.setName("Income last 7 days");
        linechart.getData().add(series);        
    }

    public void Begin(String username) {
        this.username = username;        
    }
    
}
