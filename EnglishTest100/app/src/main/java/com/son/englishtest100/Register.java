package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText name, id, password, confirmpassword;
    TextView ErrorName, ErrorID, ErrorPassword, ErrorConfirm;
    Button registerButton, toLoginButton;
    public Database Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ErrorName = findViewById(R.id.ErrorName);
        ErrorID = findViewById(R.id.ErrorID);
        ErrorPassword = findViewById(R.id.ErrorPassword);
        ErrorConfirm = findViewById(R.id.ErrorConfirm);
        name = findViewById(R.id.editTextName);
        id = findViewById(R.id.editTextID);
        password = findViewById(R.id.editTextPassword);
        confirmpassword = findViewById(R.id.editTextConfirm);
        registerButton = findViewById(R.id.buttonRegister);
        toLoginButton = findViewById(R.id.buttonToLogin);
        Data = new Database(this,"Data.sqlite",null,2);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = id.getText().toString();
                String username = name.getText().toString();
                String psd = password.getText().toString();

                if(id.getText().toString().equals("")||name.getText().toString().equals("")||password.getText().toString().equals("")||confirmpassword.getText().toString().equals("")) {
                    ErrorConfirm.setText("Fields aren't empty");
                    ErrorConfirm.setTextColor(Color.RED);
                }
                else if(id.getText().toString().length()>16||name.getText().toString().length()>16||password.getText().toString().length()>16||confirmpassword.getText().toString().length()>16){
                    ErrorConfirm.setText("Fields aren't too 16 characters!");
                    ErrorConfirm.setTextColor(Color.RED);
                }
                else if(!password.getText().toString().equals(confirmpassword.getText().toString())){
                    ErrorPassword.setText("Password confirmation must match the password");
                    ErrorPassword.setTextColor(Color.RED);
                }else{
                    if(checkRegister(id.getText().toString())==true) {
                        ErrorConfirm.setText("Successful registration");
                        ErrorConfirm.setTextColor(Color.GREEN);
                        Data.QueryData("INSERT INTO User(ID,Password,Name) VALUES ('"+user+"','"+psd+"','"+username+"')");
//                      Data.QueryData("INSERT INTO User VALUES(" + id.getText().toString() + "," + password.getText().toString() + "," + name.getText().toString() + ");");
                        SaveResultData(name.getText().toString(),id.getText().toString());
                        Intent intent = new Intent(Register.this, Menu.class);
                        startActivity(intent);
                    }else if(checkRegister(id.getText().toString())==false){
                        ErrorID.setText("ID already exists");
                        ErrorID.setTextColor(Color.RED);
                    }
                }

            }
        });
        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
    public boolean checkRegister(String id){
        Cursor pos = Data.GetData("SELECT * FROM User WHERE ID = '"+id+"';");
        if(pos!=null && pos.getCount()>0){
            return false;
        }else return true;
    }
    void SaveResultData(String name,String id){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",name);
        editor.putString("ID",id);
        editor.apply();
    }
}