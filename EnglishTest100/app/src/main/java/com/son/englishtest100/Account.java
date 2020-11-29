package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Account extends AppCompatActivity {
    TextView txtName,txtUsernameID;
    ImageView next;
    Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        next = findViewById(R.id.next);
        txtName = findViewById(R.id.Name);
        txtUsernameID = findViewById(R.id.UsernameID);
        buttonLogin = findViewById(R.id.buttonLogin);

        SharedPreferences sharedPreferences2 = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String loadid = sharedPreferences2.getString("ID", null);
        final String loadname = sharedPreferences2.getString("Name",null);
        txtName.setText(loadname);
        txtUsernameID.setText(loadid);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,Menu.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this,Welcome.class);
                startActivity(intent);
            }
        });
    }

}