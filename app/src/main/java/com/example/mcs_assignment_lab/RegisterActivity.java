package com.example.mcs_assignment_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private static final String regex = "^(.+).com(.+)$";
    TextView textViewRegister;
    EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextPhoneNumber;
    Button buttonRegister, buttonLogin;

    private boolean isValid() {
        Integer flag = 0;
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();

        Pattern patternPassword;
        Matcher matcherPassword;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{1,}$";
        patternPassword = Pattern.compile(PASSWORD_PATTERN);
        matcherPassword = patternPassword.matcher(password);

        // Check if userInput is valid
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phoneNumber.isEmpty()){
            Toast toast = Toast.makeText(RegisterActivity.this, "All fields must be filled.", Toast.LENGTH_LONG);
            toast.show();
            return false;
        } else if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() && !phoneNumber.isEmpty()){
            if(name.length() < 5 ){
                Toast toast = Toast.makeText(RegisterActivity.this, "Full Name must be at least 5 characters long.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            } else if (!email.endsWith(".com")) {
                Toast toast2 = Toast.makeText(RegisterActivity.this, "Email must be ended by .com", Toast.LENGTH_LONG);
                toast2.show();
                return false;
            } else if(!matcherPassword.matches()){
                Toast toast = Toast.makeText(RegisterActivity.this, "Password must be alphanumeric & has capital letter.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            } else if(!confirmPassword.equals(password)){
                Toast toast = Toast.makeText(RegisterActivity.this, "Password does not match.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        textViewRegister = findViewById(R.id.textViewRegister);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonRegister = findViewById(R.id.buttonRegister_Register);
        buttonLogin = findViewById(R.id.buttonLogin_Register);

        buttonRegister.setOnClickListener((v) -> {

            if(isValid()){
                int size = dataBaseUser.usersList.size();
                dataBaseUser tempData = new dataBaseUser(size++, editTextName.getText().toString(), editTextEmail.getText().toString(), editTextPassword.getText().toString(), editTextPhoneNumber.getText().toString());
                dataBaseUser.usersList.add(tempData);

                Toast toast = Toast.makeText(RegisterActivity.this, "Account Created!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        buttonLogin.setOnClickListener((e) -> {
            // Navigate to another activity
            Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent2);
        });


    }
}