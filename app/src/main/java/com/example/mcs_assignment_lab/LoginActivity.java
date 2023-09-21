package com.example.mcs_assignment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button buttonRegister, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        buttonRegister = findViewById(R.id.buttonRegister_Login);
        buttonLogin = findViewById(R.id.buttonLogin_Login);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);


        buttonLogin.setOnClickListener((v) -> {

            String emails = email.getText().toString();
            String passwords = password.getText().toString();

            // Validation Email
            if(emails.isEmpty() && passwords.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "All fields must be filled.", Toast.LENGTH_LONG);
                toast.show();
            }  else if (!emails.endsWith(".com")) {
                Toast toast2 = Toast.makeText(LoginActivity.this, "Email must be ended by .com", Toast.LENGTH_LONG);
                toast2.show();
            } else if(emails.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "Please enter your email.", Toast.LENGTH_LONG);
                toast.show();
            } else if(passwords.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_LONG);
                toast.show();
            }

            for (dataBaseUser x: dataBaseUser.usersList) {
                if(x.getEmail().equals(emails) && x.getPassword().equals(passwords)) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);

                    dataBaseTransaction.getInstance().setCurrentUser(emails);

                    Toast toast = Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
            }

            Toast toast = Toast.makeText(LoginActivity.this, "Your email address or password incorrect.", Toast.LENGTH_LONG);
            toast.show();


        });

        buttonRegister.setOnClickListener((v) -> {
            // Navigate to another activity
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });


    }
}