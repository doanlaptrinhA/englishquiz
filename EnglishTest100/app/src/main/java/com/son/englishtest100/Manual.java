package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manual extends AppCompatActivity {
    Button buttonreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        buttonreturn = findViewById(R.id.buttonReturn);
        buttonreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manual.this,Menu.class);
                startActivity(intent);
            }
        });
    }
}