package com.example.mcs_assignment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicineDetailPage extends AppCompatActivity {

    EditText quantity;
    Button buttonPurchase;
    TextView medicineName, medicinePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail_page);

        quantity = findViewById(R.id.editTextQuantity);
        buttonPurchase = findViewById(R.id.buttonPurchase);
        medicineName = findViewById(R.id.textViewTitle);
        medicinePrice = findViewById(R.id.textViewPriceDetailPage);

//        String quantityOfPurchase = quantity.getText().toString();
//        String quantityOfPurchase = "1"
        String medicineNameOfPurchase = medicineName.getText().toString();
        String medicinePriceOfPurchase = medicinePrice.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());
        String emailUsername = dataBaseTransaction.getInstance().getCurrentUser();



        buttonPurchase.setOnClickListener((v) -> {
            String quantityOfPurchase = quantity.getText().toString();

            int totalQuantity;

            if (quantityOfPurchase.equals("")){
                Toast toast = Toast.makeText(MedicineDetailPage.this, "adsadssda", Toast.LENGTH_LONG);
                toast.show();
                return;
            } else {
                totalQuantity= Integer.valueOf(quantityOfPurchase);
            }

            if (totalQuantity < 1 ){
                Toast toast = Toast.makeText(MedicineDetailPage.this, "Quantity must be at least 1 item.", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(MedicineDetailPage.this, "Purchase successful!", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
                startActivity(intent);
                dataBaseTransaction.getInstance().addToMyList(currentDateandTime, medicineNameOfPurchase, medicinePriceOfPurchase, quantityOfPurchase, emailUsername);
            }
        });


    }
}