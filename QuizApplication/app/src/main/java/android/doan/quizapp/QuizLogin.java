package android.doan.quizapp;

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

public class QuizLogin extends AppCompatActivity {
    EditText id, password;
    TextView Error,RegisterButton;
    Button LoginButton;
    public DatabaseHelper Data;
    String checkedID=null, checkedPassword=null, name=null,Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login);

        id = findViewById(R.id.editTextID);
        password = findViewById(R.id.editTextTextPassword);
        Error = findViewById(R.id.ErrorConfirm);
        LoginButton = findViewById(R.id.buttonLogin);
        RegisterButton = findViewById(R.id.buttonToRegister);


        Data = new DatabaseHelper(this,"Data.sqlite",null,2);
        Data.QueryData("CREATE TABLE IF NOT EXISTS User(STT INTEGER PRIMARY KEY AUTOINCREMENT, ID STRING, Password STRING, Name STRING)");
        Data.QueryData("INSERT INTO User(ID,Password,Name) VALUES ('111','111','Long')");

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().equals("") || password.getText().toString().equals("")){
                    Error.setText("Fields aren't empty");
                    Error.setTextColor(Color.RED);
                }else{
                    if (checkLogin(id.getText().toString(),password.getText().toString())== true){
                        LoadResultData(name);
                        SaveResultData(name,checkedID);
                        Error.setText("Logged in successfully");
                        Error.setTextColor(Color.GREEN);
                        Intent intent = new Intent(QuizLogin.this, QuizDashboard.class);
                        startActivity(intent);
                    }else  if(checkLogin(id.getText().toString(),password.getText().toString())== false){
                        Error.setText("ID or Password is incorrect");
                        Error.setTextColor(Color.RED);
                    }

                }

            }
        });
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizLogin.this, QuizRegister.class);
                startActivity(intent);
            }
        });
//        LoginButton.setOnTouchListener (new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                MediaPlayer mp = MediaPlayer.create(QuizLogin.this,R.raw.music1);
//                mp.start();
//                return false;
//            }
//        });
    }
    public boolean checkLogin(String id, String password) {
        Cursor pos = Data.GetData("SELECT * FROM User WHERE ID = '" + id + "';");
        if(pos != null&& pos.getCount()>0){
            pos.moveToFirst();
            checkedID = pos.getString(1);
            checkedPassword = pos.getString(2);
            name = pos.getString(3);
            if (checkedID.equals(id) == true) {
                if (checkedPassword.equals(password) == true)
                    return true;
            }else if(id.equals(checkedID)==false||password.equals(checkedPassword)==false)
                return false;
        }else {
            return false;
        }
        return false;
    }
    public void LoadResultData(String name){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences !=null){
            Username = sharedPreferences.getString("Name",name);
        }
    }
        void SaveResultData(String name,String checkedID){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",name);
        editor.putString("ID",checkedID);
        editor.apply();
    }


}