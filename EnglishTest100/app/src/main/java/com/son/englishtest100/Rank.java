package com.son.englishtest100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Rank extends AppCompatActivity {
    Button buttonReturnMenu;
    ListView listRank;
    ArrayList<String> listUser;
    ArrayAdapter adapter = null;
    int HighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        buttonReturnMenu = findViewById(R.id.buttonReturnMenu);
        listRank = findViewById(R.id.listviewRank);

        buttonReturnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rank.this,Menu.class);
                startActivity(intent);
            }
        });

        listUser = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listUser);
        listRank.setAdapter(adapter);

        LoadHighScore();
    }

    void LoadHighScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences !=null){
            HighScore = sharedPreferences.getInt("H",0);
            String KQ = Integer.toString(HighScore);
            listUser.add(KQ);
        }
    }
}
