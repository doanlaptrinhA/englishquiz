package android.doan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Rank extends AppCompatActivity {
    Button buttonReturnMenu;
    ListView listRank;
    ArrayList<String> listUser;
    ArrayAdapter adapter = null;
    Database Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        Data = new Database(this,"Data.sqlite",null,2);
        buttonReturnMenu = findViewById(R.id.buttonReturnMenu);
        listRank = findViewById(R.id.listviewRank);

        List listUser = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listUser);
        listRank.setAdapter(adapter);

        Cursor pos = Data.GetData("SELECT DISTINCT ID,Level,Score FROM QuizScore ORDER BY Score DESC LIMIT 5;");
        int i=0;
        if(pos != null)
        {
        while(pos.moveToNext())
        {
            i++;
            String a1 = pos.getString(0);
            String a2 = pos.getString(1);
            Float a3 = pos.getFloat(2);
            String a4 = Float.toString(a3);
            String mixed = "Top " + i + " - " + a1 +" - " +a2 +" - " + a4;
            listUser.add(mixed);
        }
        pos.close();
        }


        buttonReturnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rank.this,Menu.class);
                startActivity(intent);
            }
        });
    }

}

