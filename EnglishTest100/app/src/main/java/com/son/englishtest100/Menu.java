package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
    ImageView buttonTest, buttonRank, buttonReturnLogin, buttonManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonTest = findViewById(R.id.buttonTest);
        buttonRank = findViewById(R.id.buttonRank);
        buttonManual = findViewById(R.id.buttonmManual);
        buttonReturnLogin = findViewById(R.id.buttonReturnLogin);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Level.class);
                startActivity(intent);
            }
        });
        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Rank.class);
                startActivity(intent);
            }
        });
        buttonManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Manual.class);
                startActivity(intent);
            }
        });
        buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Welcome.class);
                startActivity(intent);
            }
        });
    }
}