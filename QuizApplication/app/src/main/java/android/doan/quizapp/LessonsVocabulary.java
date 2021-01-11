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

public class LessonsVocabulary extends AppCompatActivity {
    MediaPlayer mp;
    int length;
    Button btnAnimals, btnRelationship, btnFoodDrink, btnHealth, btnCompany, btnArts;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_lessons_vocabulary);

        next = findViewById(R.id.next);
        btnAnimals = findViewById(R.id.btnAnimals);
        btnRelationship = findViewById(R.id.btnRelationship);
        btnFoodDrink = findViewById(R.id.btnFoodDrink);
        btnHealth = findViewById(R.id.btnHealth);
        btnCompany = findViewById(R.id.btnCompany);
        btnArts = findViewById(R.id.btnArts);

        mp = MediaPlayer.create(LessonsVocabulary.this, R.raw.lessonsmusic);
        mp.start();
        mp.setLooping(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(LessonsVocabulary.this, LessonsMenu.class);
                startActivity(intent);
                finish();
            }
        });

        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Animals");
                builder.setMessage(Html.fromHtml("<b>Bear(noun) /bɛr/:</b> Con gấu <br>" +
                        "<b>Bird (noun) /bɜrd/:</b> Con chim <br>" +
                        "<b>Cat (noun) /kæt/:</b> Con mèo <br>" +
                        "<b>Chicken (noun) /ˈʧɪkən/:</b> Con gà <br>" +
                        "<b>Cow (noun) /kaʊ/:</b> Con bò <br>" +
                        "<b>Donkey (noun) /ˈdɑŋki/:</b> Con lừa <br>" +
                        "<b>Elephant (noun) /ˈɛləfənt/:</b> Con voi <br>" +
                        "<b>Insect (noun) /ˈɪnˌsɛkt/:</b> Côn trùng <br>" +
                        "<b>Lion (noun) /ˈlaɪən/:</b> Sư tử <br>" +
                        "<b>Rabbit (noun) /ˈræbət/:</b> Con thỏ <br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnRelationship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Relationships");
                builder.setMessage(Html.fromHtml("<b>Acquaintance (noun) /əˈkweɪntəns/:</b> Người quen <br>" +
                        "<b>Argue (verb): /ˈɑrgju/:</b> Tranh cãi <br>" +
                        "<b>Boss (noun): /bɑs/:</b> Sếp, cấp trên <br>" +
                        "<b>Break up (phrasal verb) /breɪk ʌp/ :</b> Chia tay <br>" +
                        "<b>Colleague/Coworker (noun): /ˈkɑlig/ – /ˈkoʊˈwɜrkər/:</b> Đồng nghiệp <br>" +
                        "<b>Conflict (noun) – (verb) /ˈkɑnflɪkt/:</b> Bất đồng, xung đột <br>" +
                        "<b>Introduce (verb) /ˌɪntrəˈdus/ :</b> Giới thiệu <br>" +
                        "<b>Couple (noun) /ˈkʌpəl/:</b> Cặp đôi <br>" +
                        "<b>Enemy (noun) /ˈɛnəmi/:</b> Kẻ thù <br>" +
                        "<b>Friendship (noun) /ˈfrɛndʃɪp/ :</b> Tình bạn <br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnFoodDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Foods & Drinks");
                builder.setMessage(Html.fromHtml("<b>Bake (verb) /beɪk/:</b> Nướng bánh <br>" +
                        "<b>Beef (noun) /bif/:</b> Thịt bò <br>" +
                        "<b>Beer (noun): /bɪr/:</b> Bia <br>" +
                        "<b>Bread (noun) /brɛd/:</b> Bánh mì <br>" +
                        "<b>Delicious (adjective) /dɪˈlɪʃəs/:</b> Vị ngon <br>" +
                        "<b>Fast food (noun) /fæst fud/:</b> Đồ ăn nhanh <br>" +
                        "<b>Fresh (adjective) /frɛʃ/:</b> Tươi sống, tươi ngon <br>" +
                        "<b>Grill (verb): /grɪl/:</b> Nướng <br>" +
                        "<b>Herb (noun) /ɜrb/:</b> Thảo mộc <br>" +
                        "<b>Juice (noun) /ʤus/:</b> Nước ép <br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });

        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Health");
                builder.setMessage(Html.fromHtml("<b>Headache (noun) /ˈhɛˌdeɪk/:</b> Đau đầu <br>" +
                        "<b>Backache (noun) /ˈbæˌkeɪk/:</b> Đau lưng <br>" +
                        "<b>Toothache (noun) /tuθ–eɪk /:</b> Đau răng <br>" +
                        "<b>Stomachache (noun) /ˈstʌmək–eɪk /:</b> Đau bụng, đau dạ dày <br>" +
                        "<b>Bandage (noun) /ˈbændɪʤ/:</b> Băng cá nhân <br>" +
                        "<b>Bleed (verb) /blid/:</b> Chảy máu <br>" +
                        "<b>Clinic (noun) /ˈklɪnɪk/:</b> Phòng khám <br>" +
                        "<b>Cold (noun) /koʊld//:</b> Cảm lạnh <br>" +
                        "<b>Cure (verb) /kjʊr/:</b> Chữa trị <br>" +
                        "<b>Diet (noun) /ˈdaɪət/:</b> Chế độ ăn uống, ăn kiêng <br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });

        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Company");
                builder.setMessage(Html.fromHtml("<b>Accountant (noun) /əˈkaʊntənt/:</b> Kế toán <br>" +
                        "<b>Capital (noun) /ˈkæpətəl/:</b> Vốn <br>" +
                        "<b>Department (noun) /dɪˈpɑrtmənt/:</b> Phòng ban, bộ phận <br>" +
                        "<b>Director (noun) /dəˈrɛktər/:</b> Giám đốc <br>" +
                        "<b>Dividend (noun) /ˈdɪvɪˌdɛnd/:</b> Cổ tức <br>" +
                        "<b>Employ (verb) /ɛmˈplɔɪ/:</b> Tuyển dụng <br>" +
                        "<b>Employer (noun) /ɛmˈplɔɪər/:</b> Nhà tuyển dụng <br>" +
                        "<b>Enterprise (noun) /ˈɛntərˌpraɪz/:</b> Doanh nghiệp <br>" +
                        "<b>Firm (noun) /fɜrm/:</b> Tập đoàn <br>" +
                        "<b>Invest (verb) /ɪnˈvɛst/:</b> Đầu tư <br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsVocabulary.this);
                builder.setTitle("Arts");
                builder.setMessage(Html.fromHtml("<b>Applaud (verb) /əˈplɔd/:</b> Vỗ tay, tán thưởng <br>" +
                        "<b>Artist (noun) /ˈɑrtɪst/:</b> Nghệ sĩ <br>" +
                        "<b>Artwork (noun) /ˈɑrˌtwɜrk/:</b> Tác phẩm nghệ thuật <br>" +
                        "<b>Audience (noun) /ˈɔdiəns/:</b> Khán giả <br>" +
                        "<b>Band (noun) /bænd/:</b> Ban nhạc <br>" +
                        "<b>Brush (noun) /brʌʃ/:</b> Cọ vẽ <br>" +
                        "<b>Camera (noun) /ˈkæmrə/:</b> Máy ảnh <br>" +
                        "<b>Choir (noun): /ˈkwaɪər/:</b> Dàn hợp xướng <br>" +
                        "<b>Collection (noun) /kəˈlɛkʃən/:</b> Bộ sưu tập <br>" +
                        "<b>Composer (noun) /kəmˈpoʊzər/:</b> Nhà soạn nhạc <br>"
                ));
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
