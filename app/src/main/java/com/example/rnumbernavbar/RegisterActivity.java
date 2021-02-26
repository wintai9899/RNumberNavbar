package com.example.rnumbernavbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText reg_name;
    private EditText reg_password;
    private EditText reg_password2;
    private EditText reg_email;
    private Button btn_register;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        reg_name = findViewById(R.id.reg_name);
        reg_password = findViewById(R.id.reg_password);
        reg_password2 = findViewById(R.id.reg_password2);
        reg_email = findViewById(R.id.reg_email);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new RegisterButton());

    }

    public class RegisterButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String username = reg_name.getText().toString().trim();
            String password = reg_password.getText().toString().trim();
            String password2 = reg_password2.getText().toString().trim();
            String mail = reg_email.getText().toString().trim();
            //Start to Register
            if (v.getId() == R.id.btn_register) {
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(password2) || TextUtils.isEmpty(mail)) {
                    Toast.makeText(RegisterActivity.this, "Cannot be Empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(password, password2)) {
                        //Register
                        //SaveInfo.SaveInformation(RegisterActivity.this,username,password,password2,mail);
                        Toast.makeText(RegisterActivity.this, "You Are Registerd!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords are different", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

}
