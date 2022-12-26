package org.example;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
@FXML
    private TextField firstName;
@FXML
   private TextField lastName;
@FXML
   private TextField address;
@FXML
   private ChoiceBox<String> sp;
@FXML
   private ChoiceBox<String> bw;
@FXML
  private   ChoiceBox<String> du;
@FXML
    private Button save;
@FXML
    private  Button clear;
@FXML
    private Button deleteRow;
ObservableList<Customer> customers= FXCollections.observableArrayList();
Customer customer;
@FXML
    TableView<Customer> table=new TableView<>();
public Controller(){}
    @FXML
    private void initialize() {
        customer = new Customer();
        firstName.textProperty().bindBidirectional(customer.firstNameProperty());
        lastName.textProperty().bindBidirectional(customer.lastNameProperty());
        address.textProperty().bindBidirectional(customer.addressProperty());
        sp.valueProperty().bindBidirectional(customer.speedProperty());
        bw.valueProperty().bindBidirectional(customer.bandwidthProperty());
        du.valueProperty().bindBidirectional(customer.durationProperty());
sp.getItems().addAll("2", "5", "10", "20", "50", "100");
bw.getItems().addAll("1", "5", "10", "100", "Flat");
du.getItems().addAll("1 year", "2 year");

    }
@FXML
    private void save(){
    if (customer.isValid()) {
        customers = table.getItems();
        customers.add(new Customer(firstName.getText(), lastName.getText(), address.getText(),
                sp.getSelectionModel().getSelectedItem(), bw.getSelectionModel().getSelectedItem(),
                du.getSelectionModel().getSelectedItem()));
        table.setItems(customers);
    }else {
        StringBuilder errMsg=new StringBuilder();
        ArrayList<String> errList=customer.errorListProperty().get();
        for (String errList1:errList){
            errMsg.append(errList1);
        }
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText(errMsg.toString());
        alert.showAndWait();
        errList.clear();
    }
}
@FXML
private void clear(){
customer.firstNameProperty().set("");
customer.lastNameProperty().set("");
customer.addressProperty().set("");
customer.speedProperty().set("");
customer.bandwidthProperty().set("");
customer.durationProperty().set("");

}
@FXML
    private void delete(){
    customers=table.getItems();
    int i=table.selectionModelProperty().getValue().getSelectedIndex();
    if (i!=-1){
        customers.remove(i);
        table.setItems(customers);
    }

}
}
