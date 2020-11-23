package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button btnEnd;
    TextView textName, textLevel, textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnEnd = findViewById(R.id.buttonEnd);
        textName = findViewById(R.id.textName);
        textLevel = findViewById(R.id.textLevel);
        textResult = findViewById(R.id.textResult);

        Intent callerIntent=getIntent();
        final Bundle packageFromCaller= callerIntent.getBundleExtra("MyPackage");
        RankedResult();
        textResult.setText(packageFromCaller.getInt("KQ")+"/"+ packageFromCaller.getInt("Socau"));
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this,Menu.class);
                startActivity(intent);
            }
        });
    }
    public void RankedResult(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",textName.toString());
        editor.apply();
    }
}