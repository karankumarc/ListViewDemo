package com.projects.karan.listviewdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsernameReg, editTextPasswordReg, editTextUsernameLogin, editTextPasswordLogin;
    Button buttonLogin, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsernameReg = (EditText) findViewById(R.id.editTextUsernameRegister);
        editTextUsernameLogin = (EditText) findViewById(R.id.editTextUsernameLogin);
        editTextPasswordReg = (EditText) findViewById(R.id.editTextPasswordRegister);
        editTextPasswordLogin = (EditText) findViewById(R.id.editTextPasswordLogin);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsernameReg.getText().toString();
                String pass = editTextPasswordReg.getText().toString();

                // Write data to Shared Preference file
                SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("KEY_USERNAME", username);
                editor.putString("KEY_PASSWORD", pass);
                editor.apply();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = editTextUsernameLogin.getText().toString();
                String pass = editTextPasswordLogin.getText().toString();


                // Read shared preferences
                String defaultValue = "empty";
                SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
                String username = sharedPreferences.getString("KEY_USERNAME", defaultValue);
                String password = sharedPreferences.getString("KEY_PASSWORD", defaultValue);

                if(username.equals(uname)&& password.equals(pass)){
                    // Successfully login
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
