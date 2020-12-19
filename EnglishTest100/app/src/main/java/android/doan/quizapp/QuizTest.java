package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuizTest extends AppCompatActivity {
    TextView textDokho, textSocauhoi, textCauhoi;
    RadioGroup RG;
    RadioButton optA, optB, optC, optD;
    ImageView nextBtn, cancel;
    ArrayList<QuestionDatabase> test = new ArrayList<>();
    int position = 0;
    int ketqua = 0;
    int length;
    MediaPlayer mp;
    final ArrayList askedlist = new ArrayList();
    final ArrayList correctans = new ArrayList();
    final ArrayList answeredlist = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_maintest);
        textDokho = findViewById(R.id.textDokho);
        textSocauhoi = findViewById(R.id.textSocauhoi);
        textCauhoi = findViewById(R.id.textCauhoi);
        nextBtn = findViewById(R.id.buttonNext);
        RG = findViewById(R.id.radioGroup);
        optA = findViewById(R.id.radioButtonA);
        optB = findViewById(R.id.radioButtonB);
        optC = findViewById(R.id.radioButtonC);
        optD = findViewById(R.id.radioButtonD);
        cancel = findViewById(R.id.cancelbutton);

        mp = MediaPlayer.create(QuizTest.this, R.raw.music2);
        mp.start();
        mp.setLooping(true);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(QuizTest.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit ??");
                builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mp.reset();
                        mp.stop();
                        Intent intent = new Intent(QuizTest.this, QuizDashboard.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });

        textDokho.setText(getIntent().getBundleExtra("dataTest").getString("level"));
        textSocauhoi.setText(getIntent().getBundleExtra("dataTest").getString("soCauHoi"));

        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("RandomQuestionList");
        test = (ArrayList<QuestionDatabase>) bundle.getSerializable("RandomArrayList");

        Display(position);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idCheck = RG.getCheckedRadioButtonId();
                askedlist.add(test.get(position).CauHoi);
                correctans.add(test.get(position).Answer);
                switch (idCheck) {
                    case R.id.radioButtonA:
                        answeredlist.add(optA.getText().toString());
                        if (optA.getText().toString().compareTo(test.get(position).Answer) == 0) {
                            ketqua = ketqua + 1;
                        }
                        break;
                    case R.id.radioButtonB:
                        answeredlist.add(optB.getText().toString());
                        if (optB.getText().toString().compareTo(test.get(position).Answer) == 0) {
                            ketqua = ketqua + 1;
                        }
                        break;
                    case R.id.radioButtonC:
                        answeredlist.add(optC.getText().toString());
                        if (optC.getText().toString().compareTo(test.get(position).Answer) == 0) {
                            ketqua = ketqua + 1;
                        }
                        break;
                    case R.id.radioButtonD:
                        answeredlist.add(optD.getText().toString());
                        if (optD.getText().toString().compareTo(test.get(position).Answer) == 0) {
                            ketqua = ketqua + 1;
                        }
                        break;
                    default:
                        answeredlist.add("Empty answer");
                        ketqua = ketqua + 0;
                }
                position++;
                if (position >= test.size()) {
                    mp.stop();
                    Intent intent = new Intent(QuizTest.this, TestResult.class);
                    Bundle bundle = new Bundle();
                    Bundle askedquestion = new Bundle();
                    askedquestion.putParcelableArrayList("askedlist", askedlist);
                    askedquestion.putParcelableArrayList("correct", correctans);
                    askedquestion.putParcelableArrayList("answered", answeredlist);
                    bundle.putInt("KQ", ketqua);
                    bundle.putInt("Socau", position);
                    intent.putExtra("MyPackage", bundle);
                    intent.putExtra("QuestionDatabase", askedquestion);
                    startActivity(intent);
                    finish();
                } else {
                    Display(position);
                }
            }
        });


        optA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizTest.this, R.raw.click);
                mp.start();
                return false;
            }
        });
        optB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizTest.this, R.raw.click);
                mp.start();
                return false;
            }
        });
        optC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizTest.this, R.raw.click);
                mp.start();
                return false;
            }
        });
        optD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizTest.this, R.raw.click);
                mp.start();
                return false;
            }
        });
        nextBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizTest.this, R.raw.click);
                mp.start();
                return false;
            }
        });

    }

    void Display(int i) {
        textCauhoi.setText(test.get(i).CauHoi);
        ArrayList<String> mixed = new ArrayList<>();
        mixed.add(test.get(i).AnswerA);
        mixed.add(test.get(i).AnswerB);
        mixed.add(test.get(i).AnswerC);
        mixed.add(test.get(i).AnswerD);
        Collections.shuffle(mixed);
        optA.setText(mixed.get(0));
        optB.setText(mixed.get(1));
        optC.setText(mixed.get(2));
        optD.setText(mixed.get(3));
        RG.clearCheck();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
        length = mp.getCurrentPosition();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.seekTo(length);
        mp.start();
        mp.setLooping(true);
    }


}