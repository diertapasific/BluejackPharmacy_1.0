package com.example.mcs_assignment_lab;

import java.util.ArrayList;

public class dataBaseTransaction {
    private static dataBaseTransaction instance;
    private ArrayList<Transaction> myList;
    private String currentUser;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    private dataBaseTransaction() {
        myList = new ArrayList<>();
    }

    public static synchronized dataBaseTransaction getInstance() {
        if (instance == null) {
            instance = new dataBaseTransaction();
        }
        return instance;
    }

    public ArrayList<Transaction> getMyList() {
        return myList;
    }

    public void removeFromMyList(int position) {
        myList.remove(position);
    }

    public void updateMyList(int index, String[] items) {
        Transaction transaction = new Transaction(items[0],items[1],items[2],items[3], currentUser);
        myList.set(index, transaction);
    }

    public void addToMyList(String currentDateandTime, String medicineNameOfPurchase, String medicinePriceOfPurchase, String quantityOfPurchase, String emailUsername) {
        Transaction transaction = new Transaction(currentDateandTime,medicineNameOfPurchase,medicinePriceOfPurchase,quantityOfPurchase,emailUsername);
        myList.add(transaction);
    }
}