package com.example.mcs_assignment_lab;

public class Medicine {

    String heading, manufacturer, price;
    int titleImage;

    public Medicine(String heading, String manufacturer, int titleImage, String price) {
        this.manufacturer = manufacturer;
        this.heading = heading;
        this.titleImage = titleImage;
        this.price = price;
    }

}
