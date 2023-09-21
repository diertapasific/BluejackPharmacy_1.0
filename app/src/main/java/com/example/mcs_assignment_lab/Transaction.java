package com.example.mcs_assignment_lab;

public class Transaction {

    String date, medicineName, medicinePrice, medicineManufacturer, medicineQuantity, userID;

    public Transaction(String date, String medicineName,String medicinePrice,String medicineQuantity, String userID) {
        this.date = date;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineQuantity = medicineQuantity;
        this.userID = userID;
    }
}
