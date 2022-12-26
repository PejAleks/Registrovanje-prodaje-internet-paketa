package org.example;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

public class Customer {
    private final StringProperty firstName=new SimpleStringProperty(this,"firstName","");
    private final StringProperty lastName=new SimpleStringProperty(this,"lastName","");
    private final StringProperty address=new SimpleStringProperty(this,"address","");
    private final StringProperty speed= new SimpleStringProperty(this,"speed","");
    private final StringProperty bandwidth=new SimpleStringProperty(this,"bandwidth","");
    private final StringProperty duration=new SimpleStringProperty(this,"duration","");

    public Customer(){

    }
    public Customer(String firstName, String lastName,String address,String speed,String bandwidth,
    String duration){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.duration.set(duration);
    }



    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getSpeed() {
        return speed.get();
    }

    public StringProperty speedProperty() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public String getBandwidth() {
        return bandwidth.get();
    }

    public StringProperty bandwidthProperty() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth.set(bandwidth);
    }

    public String getDuration() {
        return duration.get();
    }

    public StringProperty durationProperty() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    private final ObjectProperty<ArrayList<String>> errorList=new SimpleObjectProperty<>(this,"errorList",new ArrayList<>());

    public ArrayList<String> getErrorList() {
        return errorList.get();
    }

    public ObjectProperty<ArrayList<String>> errorListProperty() {
        return errorList;
    }

    public void setErrorList(ArrayList<String> errorList) {
        this.errorList.set(errorList);
    }

    public boolean isValid(){
        boolean isValid=true;
        if (firstName.get()!=null && firstName.get().equals("")){
                errorList.getValue().add("First name can't be empty!");
                isValid=false;
        }
        if (lastName.get()!=null && lastName.get().equals("")){
            errorList.getValue().add("Last name can't be empty!");
            isValid=false;
        }
        if (address.get()!=null && address.get().equals("")){
            errorList.getValue().add("Address can't be empty!");
            isValid=false;
        }
        if (speed.get()!=null && speed.get().equals("")){
            errorList.getValue().add("Speed can't be empty!");
            isValid=false;
        }

        if (bandwidth.get()!=null && bandwidth.get().equals("")){
            errorList.getValue().add("Bandwidth can't be empty!");
            isValid=false;
        }
        if (duration.get()!=null && duration.get().equals("")){
            errorList.getValue().add("Duration can't be empty!");
            isValid=false;
        }
        return isValid;
    }
}
