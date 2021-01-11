package android.doan.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LessonsGrammar extends AppCompatActivity {
    MediaPlayer mp;
    int length;
    Button btnPreSimp, btnPastSimp, btnFutureSimp, btnPreCons, btnPastCons, btnFutureCons, btnPrePerf, btnPastPerf, btnFuturePerf, btnPresentPerfCons, btnPastPerfCons, btnFuturePerfCons;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_lessons_grammar);

        next = findViewById(R.id.next);
        btnPreSimp = findViewById(R.id.btnPresentsimp);
        btnPastSimp = findViewById(R.id.btnPastsimp);
        btnFutureSimp = findViewById(R.id.btnFutureSimp);
        btnPreCons = findViewById(R.id.btnPresentcons);
        btnPastCons = findViewById(R.id.btnPastcons);
        btnFutureCons = findViewById(R.id.btnFuturecons);
        btnPrePerf = findViewById(R.id.btnPresentperf);
        btnPastPerf = findViewById(R.id.btnPastperf);
        btnFuturePerf = findViewById(R.id.btnFutureperf);
        btnPresentPerfCons = findViewById(R.id.btnPresentperfcons);
        btnPastPerfCons = findViewById(R.id.btnPastperfcons);
        btnFuturePerfCons = findViewById(R.id.btnFutureperfcons);

        mp = MediaPlayer.create(LessonsGrammar.this, R.raw.lessonsmusic);
        mp.start();
        mp.setLooping(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(LessonsGrammar.this, LessonsMenu.class);
                startActivity(intent);
                finish();
            }
        });

        btnPreSimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Present Simple Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>I/ you/ we/ they + bare infinitive</b><br>" +
                        "<i>Example: We go to bed early.</i> <br>" +
                        "<b>He/ she/ it/ James + Verb – s/ es</b><br>" +
                        "<i>Example: She goes to bed early.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>I/ you/ we/ they + don't + bare infinitive</b><br>" +
                        "<i>Example: They don’t go to bed early.</i> <br>" +
                        "<b>He/ she/ it/ James + doesn't + bare infinitive</b><br>" +
                        "<i>Example: James doesn’t go to bed early.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Do + I/ you/ we/ they + bare infinitive?</b><br>" +
                        "<i>Example: Do they go to bed early?</i> <br>" +
                        "<b>Does + he/ she/ it/ James + bare infinitive?</b><br>" +
                        "<i>Example: Does she go to bed early?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Always, usually, often, sometimes, seldom, never, every day, every week, every month, every year, on Sundays, after school, before school <br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPastSimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Past Simple Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + was/ were + …</b><br>" +
                        "<i>Example: They were sick last week.</i> <br>" +
                        "<b>Subject + Past simple</b><br>" +
                        "<i>Example: She went shopping last month.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + was/ were + not + …</b><br>" +
                        "<i>Example: I wasn’t sick yesterday.</i> <br>" +
                        "<b>Subject + did not + Bare infinitive</b><br>" +
                        "<i>Example: We didn’t get up late yesterday.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Were/ was + Subject + …?</b><br>" +
                        "<i>Example: Were you sick yesterday?</i> <br>" +
                        "<b>Did + Subject + Bare infinitive?</b><br>" +
                        "<i>Example: Did you get up late yesterday?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Yesterday, last week, last month, last year, last Christmas, in 2017, ago<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnFutureSimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Future Simple Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + will + Bare infinitive</b><br>" +
                        "<i>My mom will go shopping tomorrow.</i> <br>" +
                        "<b>Subject + am/is/are + going to + Bare infinitive</b><br>" +
                        "<i>I am going to go to Canada next month.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + will not + Bare infinitive</b><br>" +
                        "<i>Example: My mom won’t go shopping tomorrow.</i> <br>" +
                        "<b>Subject + am/is/are + not + going to + Bare infinitive</b><br>" +
                        "<i>I am not going to go to Canada next month.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Will + Subject + Bare infinitive?</b><br>" +
                        "<i>Example: Will your mom go shopping tomorrow?</i> <br>" +
                        "<b>Am/is/are + Subject + going to + Bare infinitive?</b><br>" +
                        "<i>Are you going to go to Canada next month?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Tomorrow, tonight, next week, next month, next year, next summer <br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPreCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Present Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + am/ is/ are + Verb - ING</b><br>" +
                        "<i>Example: She is writing to her grandma now.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + am/ is/ are + not + Verb – ING</b><br>" +
                        "<i>Example: She isn’t writing to her grandma now.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Am/ is/ are + Subject + Verb – ING?</b><br>" +
                        "<i>Example: Is she writing to her grandma now?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "at the moment, now / just now / right now, look, listen<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPastCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Past Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + was/ were + Verb-ING</b><br>" +
                        "<i>Example: She was cooking when I came.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + was/ were + not + Verb-ING</b><br>" +
                        "<i>Example: She wasn’t cooking when I came.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Was/ were + Subject + Verb-ING?</b><br>" +
                        "<i>Example: Was she cooking when you came?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        " <br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnFutureCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Future Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + will be + Verb-ING</b><br>" +
                        "<i>Example: My mom will be going shopping this time tomorrow.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + will not be + Verb-ING</b><br>" +
                        "<i>Example: My mom won’t be going shopping this time tomorrow.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Will + Subject + be + Verb-ING?</b><br>" +
                        "<i>Example: Will your mom be going shopping this time tomorrow?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "This time next week, at 8 pm tomorrow<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPrePerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Present Perfect Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + has/ have + Past Participle</b><br>" +
                        "<i>Example: She has done her homework.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + has/ have + not + Past Participle</b><br>" +
                        "<i>Example: She has not done her homework.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Has/ Have + Subject + Past Participle?</b><br>" +
                        "<i>Example: Has she done her homework?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Already, yet, ever, never, just, only just, recently, so far, until now, up to now<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPastPerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Past Perfect Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + had + Past Participle</b><br>" +
                        "<i>Example: She had done her homework when I came.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + had + not + Past Participle</b><br>" +
                        "<i>Example: She hadn’t done her homework when I came.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Had + Subject + Past Participle?</b><br>" +
                        "<i>Example: Had she done her homework when you came?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Already, just, never, ever<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnFuturePerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Future Perfect Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + will have + Past participle</b><br>" +
                        "<i>I’ll have done my homework by 5 pm.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + will not have + Past participle</b><br>" +
                        "<i>Example: I won’t have done my homework by 5 pm.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Will + Subject + have + Past participle?</b><br>" +
                        "<i>Example: Will you have done your homework by 5 pm?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "In (3 months, one year), by (the year 2000, 5 pm, next Monday) <br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPresentPerfCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Present Perfect Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + has/ have + been + Verb-ING</b><br>" +
                        "<i>Example: She’s been waiting here for 2 hours.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + has/ have + not + been + Verb-ING</b><br>" +
                        "<i>Example: She hasn’t been waiting here for 2 hours.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Has/ Have + Subject + been + Verb-ING?</b><br>" +
                        "<i>Example: Has she been waiting here for 2 hours?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "Since, for, how long<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnPastPerfCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Past Perfect Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + had been + Verb-ING</b><br>" +
                        "<i>Example: She had been cooking in the kitchen for hours when I got home.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + had not been + Verb-ING</b><br>" +
                        "<i>Example: She had not been cooking in the kitchen for hours when I got home.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Had + Subject + been Verb-ING?</b><br>" +
                        "<i>Example: Had she been cooking in the kitchen for hours when you got home?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        " <br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnFuturePerfCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsGrammar.this);
                builder.setTitle("Future Perfect Continuous Tense");
                builder.setMessage(Html.fromHtml("Positive: <br>" +
                        "<b>Subject + will have been + Verb - ING</b><br>" +
                        "<i>Example: I’ll have been working here for 3 years in April.</i> <br>" +
                        "<br>" +
                        "Negative: <br>" +
                        "<b>Subject + won’t have been + Verb - ING</b><br>" +
                        "<i>Example: I won’t have been working here for 3 years in April.</i> <br>" +
                        "<br>" +
                        "QuestionDatabase: <br>" +
                        "<b>Will + Subject + have been + Verb - ING?</b><br>" +
                        "<i>Example: Will you have been working here for 3 years in April?</i> <br>" +
                        "<br>" +
                        "<b>Signal words:</b> <br>" +
                        "<br>"));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
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
