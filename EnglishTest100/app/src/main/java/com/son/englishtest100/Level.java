package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Level extends AppCompatActivity{
    ImageView buttonEasy, buttonMedium, buttonHard;
    TextView txtone,txttwo,txtthree;
    Database Data;
    ArrayList<Question> easylist, mediumlist, hardlist;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        buttonEasy = findViewById(R.id.buttonEasy);
        buttonMedium = findViewById(R.id.buttonMedium);
        buttonHard = findViewById(R.id.buttonHard);

        txtone = findViewById(R.id.txtone);
        txttwo = findViewById(R.id.txttwo);
        txtthree = findViewById(R.id.txtthree);

        Data = new Database(this,"Data.sqlite",null,1);
        Data.QueryData("DROP TABLE IF EXISTS Question");
        Data.QueryData("CREATE TABLE IF NOT EXISTS Question(Ma INTEGER PRIMARY KEY, CauHoi VARCHAR, DoKho  INTEGER, AnswerA VARCHAR, AnswerB VARCHAR, AnswerC VARCHAR, AnswerD VARCHAR, Correct VARCHAR);");
        Data.QueryData("INSERT INTO Question VALUES\n" +
                "        (1, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A.potential', 'B.agency', 'C.objective', 'D.impartial', 'B'), \n" +
                "        (2, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A.neutral', 'B.improve', 'C.relief', 'D.arrest', 'A'),\n" +
                "        (3, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. livelihood', 'B. convention', 'C. tsunami', 'D. develop', 'A'),\n" +
                "        (4, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. soldier', 'B. colleague', 'C. peacetime', 'D. title', 'B'),\n" +
                "        (5, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. advocate', 'B. potential', 'C. disaster', 'D. tsunami', 'A'),\n" +
                "        (6, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. hesitation', 'B. epidemic', 'C. dedicated', 'D. federation', 'C'),\n" +
                "        (7, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. emergency', 'B. temporary', 'C. conventional', 'D. advocator', 'B'),\n" +
                "        (8, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. relieve', 'B. protect', 'C. open', 'D. appall', 'C'),\n" +
                "        (9, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. partnership', 'B. romantic', 'C. actually', 'D. attitude', 'B'),\n" +
                "        (10, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. believe', 'B. marriage', 'C. response', 'D. maintain', 'B'),\n" +
                "        (11, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. summary', 'B. different', 'C. physical', 'D. decision', 'D'),\n" +
                "        (12, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. attractiveness', 'B. traditional', 'C. generation', 'D. American', 'C'),\n" +
                "        (13, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. certain', 'B. couple', 'C. decide', 'D. equal', 'C'),\n" +
                "        (14, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. maintain', 'B. attitude', 'C. determine', 'D. develop', 'B'),\n" +
                "        (15, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. brilliant', 'B. different', 'C. secretary', 'D. attractive', 'D'),\n" +
                "        (16, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. generational', 'B. interpersonal', 'C. discrimination', 'D. nationality', 'C'),\n" +
                "        (17, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. studious', 'B. unite', 'C. mature', 'D. involve', 'A'),\n" +
                "        (18, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. frustrating', 'B. charity', 'C. impairment', 'D. infectious', 'B'),\n" +
                "        (19, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. sociable', 'B. endanger', 'C. habitat', 'D. numerous', 'B'),\n" +
                "        (20, 'Choose the letter A, B, C or D the word that has different stress pattern from others', 1, 'A. accelerate', 'B. Catholicism', 'C. development', 'D. integration', 'D'),\n" +
                "        (21, 'They are not allowed to go out in the evening by their parents.', 2, 'A. Their parents do not want them to go out in the evening.', 'B. Their parents never let them to go out in the evening.', 'C. Going out in the evening is permitted by their parents.', 'D. Although their parents do not allow, they still go out in the evening.', 'A'),\n" +
                "        (22, 'Although my parents are busy at work, they try to find time for their children.', 2, 'A. My parents are so busy at work that they cannot find time for their children.', 'B. Busy at work as my parents are, they try to find time for their children.', 'C. My parents are too busy at work to find time for their children.', 'D. My friends rarely have time for their children because they are busy at work.', 'B'),\n" +
                "        (23, 'His eel soup is better than any other soups I have ever eaten', 2 , 'A. Of all the soups I have ever eaten, his eel soup is the best.', 'B. I have ever eaten many soups that are better than his eel soup.', 'C. His eel soup is the worst of all soups I have eaten.', 'D. His eel soup is good but I have ever eaten many others better.', 'A'),\n" +
                "        (24, 'She gets up early to prepare breakfast so that her children can come to school on time.', 2 , 'A. Despite her getting up early to prepare breakfast, her children cannot come to school on time.', 'B. Because she wanted her children to come to school on time, she gets up early to prepare breakfast.', 'C. If she does not get up early to prepare breakfast, her children will not come to school on time.', 'D. Unless she gets up early to prepare breakfast, her children will not come to school on.', 'B'),\n" +
                "        (25, 'The last time I went to the museum was a year ago.', 2 , 'A. I have not been to the museum for a year.', 'B. A year ago, I often went to the museum.', 'C. My going to the museum lasted a year.', 'D. At last I went to the museum after a year.', 'A'),\n" +
                "        (26, 'Nobody in the class is as tall as Mike.', 2 , 'A. Everybody in the class is taller than Mike.', 'B. Somebody in the class may be shorter than Mike.', 'C. Mike is the tallest student in the class.', 'D. Mike may be taller than most students in the class.', 'C'),\n" +
                "        (27, 'I haven''t got enough money to buy a new car.', 2 , 'A. I need more money to buy a new car.', 'B. I don''t want to spend more money on a new car.', 'C. A new car is not something I really need.', 'D. Money is not the most essential issue to buy a new car.', 'A'),\n" +
                "        (28, 'I am really keen on playing sports.', 2 , 'A. I am a big fan of sports.', 'B. Playing sports makes me sick.', 'C. I am not really into sports.', 'D. I can''t stand sports.', 'A'),\n" +
                "        (29, 'I will come back home soon - he said.', 2 , 'A. He advised to come back home soon.', 'B. He offered to come back home soon.', 'C. He promised to come back home soon.', 'D. He suggested that he should come back home soon.', 'C'),\n" +
                "        (30, 'He prevented his close friend from telling the truth.', 2 , 'A. He forbade his close friend to tell the truth.', 'B. He allowed his close friend to tell the truth.', 'C. He ordered his close friend to tell the truth.', 'D. He paid his close friend to tell the truth.', 'A'),\n" +
                "        (31, 'My brother speaks too loud. It is really annoying.', 2 , 'A. My brother is speaking too loud.', 'B. My brother likes to speak too loud.', 'C. My brother feels annoyed when he can''t speak too loud.', 'D. My brother is always speaking too loud.', 'D'),\n" +
                "        (32, 'She is an honest person. She is also a very friendly one.', 2 , 'A. She is an honest but friendly person.', 'B. She is not only an honest but also a very friendly person.', 'C. Though she is a honest person, she is friendly.', 'D. Being honest is necessary to become friendly.', 'B'),\n" +
                "        (33, 'He had just finished eating his breakfast. Then he fell down', 2 , 'A. Hardly did he finished eating his breakfast when he fell down', 'B. Hardly he had finished eating his breakfast when he fell down', 'C. Hardly had he finished eating his breakfast when he fell down', 'D. Hardly have he finished eating his breakfast when he fell down', 'D'),\n" +
                "        (34, 'They spent more money. They had to work harder.', 2 , 'A. The more money they spent, the harder they had to work', 'B. The more they spent money, the harder work they had to.', 'C. The more money they spent, the more harder they had to work.', 'D. The more they spent money, the more hard they had to work.', 'A'),\n" +
                "        (35, 'I don’t remember the man. You met him at the canteen last week.', 2 , 'A. I don’t remember the man whom you met him at the canteen last week.', 'B. I don’t remember the man whose you met at the canteen last week.', 'C. I don’t remember the man whom you met at the canteen last week.', 'D. I don’t remember the man that you met him at the canteen last week.', 'C'),\n" +
                "        (36, 'John is studying hard. He doesn''t want to fail the next exam.', 2 , 'A. John is studying hard in order that he not fail the next exam', 'B. John is studying hard in order not to fail the next exam', 'C. John is studying hard in order to not to fail the next exam', 'D. John is studying hard so as to fail the next exam', 'B'),\n" +
                "        (37, 'Hello, Mary!- Peter said.', 2 , 'A. Peter advised me to ask the teacher for help.', 'B. Peter recommended me not to ask the teacher for help.', 'C. Peter told me the reason why I did not ask the teacher for help.', 'D. Peter suggested that he should ask the teacher for help.', 'C'),\n" +
                "        (38, 'Why don''t you ask the teacher for help? - Peter asked me.', 2 , 'A. Peter said hello Mary. ', 'B. Peter said Mary hello.', 'C. Peter told Mary hello', 'D. Peter greeted Mary.', 'D'),\n" +
                "        (39, 'He became successful as a professional writer at the age of 20.', 2 , 'A. He did not succeed as a professional writer until he was 20.', 'B. He did not write professionally until he succeeded at the age of 20.', 'C. He succeeded as a professional writer until he was 20.', 'D. He wrote professionally until he became successful at the age of 20.', 'A'),\n" +
                "        (40, 'I regret drinking so much last night.', 2 , 'A. I wish I wouldn''t drink so much last night.', 'B. I wish I didn''t drink so much last night.', 'C. I didn''t drink so much last night.', 'D. If only I hadn''t drunk so much last night.', 'D'),\n" +
                "        (41, 'I last saw him at my twenty-first birthday party.', 2 , 'A. I haven''t seen him since my twenty-first birthday party.', 'B. I didn''t see him since my twenty-first birthday party.', 'C. I haven''t had a birthday party for twenty-one years.', 'D. I had twenty-once birthday parties.', 'A'),\n" +
                "        (42, 'Working so much will make you tired.', 2  , 'A. You are tired of working so much', 'B. You are tired because you are working so much.', 'C. If you work so much, you''ll get tired.', 'D. You were tired because you have been working so much.', 'C'),\n" +
                "        (43, 'Please don''t smoke inside the building.', 2 , 'A. Would you mind not smoking inside the building?', 'B. Would you like to smoke outside the building?', 'C. People are allowed to smoke in this building.', 'D. People don''t smoke in this building.', 'A'),\n" +
                "        (44, 'She tried very hard to pass the driving test. She could hardly pass it.', 2 , 'A. Although she didn‘t try hard to pass the driving test, she could pass it.', 'B. Despite being able to pass the driving test, she didn‘t pass it.', 'C. No matter how hard she tried, she could hardly pass the driving test', 'D. She tried very hard, so she passed the driving test satisfactorily', 'C'),\n" +
                "        (45, 'Marry loved her stuffed animal when she was young. She couldn’t sleep without it.', 2  , 'A. When Marry was young, she loved her stuffed animal so as not to sleep with it.', 'B. As Marry couldn.t sleep without her stuffed animal when she was young, she loved it.', 'C. When Marry was young, she loved her stuffed animal so much that she couldn’t sleep without it.', 'D. When Marry was young, she loved her stuffed animal though she couldn’t sleep without it.', 'C'),\n" +
                "        (46, 'He didn’t try hard. He failed the entrance exam.', 2 , 'A. On hearing a strange sound on the roof, Peter became very scared.', 'B. He became very frightened after he heard a strange sound on the roof.', 'C. He heard a strange sound on the roof and then becoming very terrified.', 'D. Peter became very frightened so he heard a strange sound on the roof.', 'C'),\n" +
                "        (47, 'Peter heard a strange sound on the roof. He became very frightened.', 2 , 'A. If he had tried hard, he would not fail the entrance exam.', 'B. If he tried hard, he would pass the entrance exam.', 'C. If he had tried hard, he would have not failed the entrance exam.', 'D. If he hadn’t failed the entrance exam, he would try hard.', 'C'),\n" +
                "        (48, 'Tim went on a two-day trip. He took more clothes than necessary.', 2 , 'A. Tim needn''t have taken so many clothes on a two-day trip.', 'B. Tim can''t have taken so many clothes on a two-day trip.', 'C. Tim couldn''t have taken so many clothes on a two-day trip.', 'D. Tim mustn''t have taken so many clothes on a two-day trip.', 'A'),\n" +
                "        (49, 'My brother speaks too loud. It is really annoying.', 2  , 'A. My brother is speaking too loud.', 'B. My brother likes to speak too loud.', 'C. My brother feels annoyed when he can''t speak too loud.', 'D. My brother is always speaking too loud.', 'D'),\n" +
                "        (50, 'There is always conflict between parents and children. However, they still should talk and share things with each other.', 2 , 'A. Although there is always conflict between parents and children, they still should talk and share things with each other.', 'B. There is always conflict between parents and children, so they still should talk and share things with each other.', 'C. Unless there is always conflict between parents and children, they still should talk and share things with each other.', 'D. Not only there is always conflict between parents and children, but they still should talk and share things with each other.', 'A'),\n" +
                "        (51, 'Your parents will help you with the problem. You should tell them the story.', 2 , 'A. Because your parents will help you with the problem, you should tell them the story.', 'B. Your parents will help you with the problem since you should tell them the story.', 'C. If your parents will help you with the problem, you should tell them the story.', 'D. Your parents will help you with the problem because you should tell them the story.', 'A'),\n" +
                "        (52, 'She is an honest person. She is also a very friendly one.', 2  , 'A. She is an honest but friendly person.', 'B. She is not only an honest but also a very friendly person.', 'C. Though she is a honest person, she is friendly.', 'D. Being honest is necessary to become friendly.', 'B'),\n" +
                "        (53, 'Mr. Pike is a famous doctor. I bought his land last year.', 2  , 'A. Mr. Pike, whose land I bought last year, is a famous doctor.', 'B. Mr. Pike, who is a famous doctor, whose land I bought last year.', 'C. Mr. Pike, whose land I bought, is a famous doctor.', 'D. Mr. Pike, who I bought his land last year, is a famous doctor.', 'A'),\n" +
                "        (54, 'Kathy did not study hard, so she failed.', 2  , 'A. Kathy knew that she would succeed in the examination.', 'B. But for her hard study, Kathy would have succeed in the examination.', 'C. Kathy studied very hard but she did not succeed in the examination.', 'D. Had Kathy studied hard, she would have passed the examination.', 'D'),\n" +
                "        (55, 'He likes the dress. Huong is wearing it.', 2  , 'A. He likes the dress which Huong is wearing it', 'B. He likes the dress Huong is wearing it', 'C. He likes the dress who Huong is wearing', 'D. He likes the dress Huong is wearing', 'D'),\n" +
                "        (56, 'Most of the classmates couldn’t come. He invited them to the birthday party.', 2  , 'A. Most of the classmates he invited to the birthday party couldn’t come.', 'B. Most of the classmates he was invited to the birthday party couldn’t come.', 'C. Most of the classmates that he invited them to the birthday party couldn’t come.', 'D. Most of the classmates which he invited to the birthday party couldn’t come', 'B'),\n" +
                "        (57, 'The church is over 500 years old. Our class visited it last summer.', 2  , 'A. The church which our class visited it last summer is over 500 years old.', 'B. The church that our class visited it last summer is over 500 years old.', 'C. The church which our class visited last summer is over 500 years old.', 'D. The church our class visit last summer is over 500 years old', 'C'),\n" +
                "        (58, 'Mai usually helps her classmates with their studies. Her classmates appreciate her.', 2 , 'A. Mai usually helps her classmates with their studies, but they appreciate her.', 'B. Mai usually helps her classmates with their studies, for they appreciate her.', 'C. Mai usually helps her classmates with their studies, so they appreciate her.', 'D. Mai usually helps her classmates with their studies, or they appreciate her.', 'C'),\n" +
                "        (59, 'We cut down many forests. The Earth becomes hot.', 2 , 'A. The more forests we cut down, the hotter the Earth becomes.', 'B. The more we cut down forests, the hotter the Earth becomes.', 'C. The more forests we cut down, the Earth becomes hotter.', 'D. The more we cut down forests, the Earth becomes hotter.', 'D'),\n" +
                "        (60, 'Unemployment rate is high. This makes many children move back to their parents house.', 2 , 'A. Many children move back to their parents'' house, which makes high unemployment rate.', 'B. High unemployment rate forces many children to move back to their parents'' house.', 'C. Moving back to their parents'' house suggests that the unemployment rate is high.', 'D. It is necessary to move back to your parents'' house if unemployment rate is high.', 'B');");

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                easylist = new ArrayList<Question>();
                getListByLevel(1,easylist);
                sendData("Easy",easylist,intent,bundle);
            }
        });
        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                mediumlist = new ArrayList<Question>();
                getListByLevel(2,mediumlist);
                sendData("Medium",mediumlist,intent,bundle);
            }
        });
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                hardlist = new ArrayList<Question>();
                getListByLevel(3,hardlist);
                sendData("Hard",hardlist,intent,bundle);
            }
        });


        txtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                easylist = new ArrayList<Question>();
                getListByLevel(1,easylist);
                sendData("Easy",easylist,intent,bundle);
            }
        });
        txttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                mediumlist = new ArrayList<Question>();
                getListByLevel(2,mediumlist);
                sendData("Medium",mediumlist,intent,bundle);
            }
        });
        txtthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                hardlist = new ArrayList<Question>();
                getListByLevel(3,hardlist);
                sendData("Hard",hardlist,intent,bundle);
            }
        });
    }
    public void getListByLevel(int level, ArrayList list){
        Cursor data = Data.GetData("SELECT * FROM Question WHERE DoKho =" + level +";");
        while(data.moveToNext()){
            Question question = new Question(data.getInt(0),data.getString(1),data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7));
            list.add(question);
        }
    }
    public void sendData(String level, ArrayList list,Intent intent, Bundle bundle){
        intent.putExtra("level",level);
        bundle.putSerializable("ArrayList",(Serializable)list);
        intent.putExtra("QuestionList",bundle);
        startActivity(intent);
    }
}
