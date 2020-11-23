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
                        "(1, 'Some snakes lay eggs, but _______ give birth to live offspring.',	1, 'A.other', 	'B.the other', 	'C.others',  'D.the others',	'C'),\n" +
                "(2, 'I can remember _________ you about this three times already.',	1, 'A.telling',  	'B.to tell',  	'C.told',  	'D.tell',	'A'), \n"+
                "(3, 'Don't  worry about the party. I'll _________ to it.',	1, 'A.offer', 	'B.care', 	'C.see', 	'D.devote',	'C'), \n"+
                "(4, '_____________ have made communication faster and easier through the use of e-mail and the Internet is widely recognize', 	'A.It is that computers', 	'B.That computers', 	'C.Computers that', 	'D.That it is computers',	'B'),\n"+
//        "(5, '_________ you should do now is to take a long holiday	That 	Which 	What 	It	C
//        "(6, '____________  you to be offered that job, would you have to move to another city?	Provided that 	Should 	Were 	Had	C
//        "(7, 'I ___________Katie, an old friend of mine, on the way home from work yesterday. 	came into 	ran into 	call off 	get into	B
//        "(8, 'Tom was wearing a suit, ___________ was unsuitable for an informal gathering.	and                             	it	which	that	C
//           "(9, '. Anne: "Make yourself at home".         -- John : "._________________." 	Yes, Can I help you?   	Not at all. Don't mention it.   	Thanks! Same to you.    	That's very kind. Thank you	D
//        "(10, 'My car would not start ____________ Jenny's started immediately	whereas 	though 	however 	nevertheless	A
//        "(11, 'You work very har I'm sure you'll have no _______ the exam	difficulties of passing 	difficulty passing	difficulties to pass 	difficulty to pass	B
//        "(12, '_____________________ director must have surprised all the staff	You nominated 	Your being nominated 	You have been nominated 	Your nominating	B
//        "(13, 'This is such an important question that we can't _________________thinking it over.	point 	use 	help 	stand	C
//        "(14, '________________ the Christmas shopping season begins.	That is after Thanksgiving 	After Thanksgiving it is	 It is after Thanksgiving that 	It is Thanksgiving that	C
//        "(15, 'My new glasses cost me _______ the last pair I bought last month.	more than three times   	three times as much as  	more three times than  	as much three times as	B
//        "(16, 'You will find their house __________ you take a good street map with you.	as long as 	even if 	unless 	otherwise	A
//        "(17, 'By the end of last March, I _____ English for five years.	was studying 	would be studying	has been studying 	had been studying	D
//        "(18, 'You'd better stop spending money, _______ you will end up in debt	unless 	otherwise 	if 	in case	B
//        "(19, 'The people in my class, _____ are very friendly.	most of international students 	the most international students	almost international students 	mostly international students	D
//        "(20, 'He is determined to finish the job _____________ long it takes	whenever	whatever	no matter	however 	D
//        "(21, 'She _____ for lost time by studying at weekends. 	got up  	set about	made up	put in	C
//        "(22, 'What is your opinion about Bob's condition?  - I recommend ___________ as much as possible.	him rest 	that he rests 	that he rest 	him to rest 	C
//        "(23, 'Alan and Sue ___________ an argument. They are not speaking to each other.	must have 	must have had 	might have 	might had 	B
//        "(24, '______________________, we tried our best to complete it.	As though the homework was difficult 	Thanks to the difficult homework     	Difficult as the homework was 	Despite the homework was difficult 	C
//        "(25, 'Only when the ground is kept moist, _________________ germinate. 	 will grass seeds    	grass seeds wil	does grass seeds	grass seeds does	C
//        "(26, 'She would rather I ________ harder now. 	study	studying	am studying	studied 	D
//        "(27, 'The concert didn't come ______ our expectations. 	up to	up against	round	up with	A
//        "(28, 'Excuse me, is anybody sitting here?   -“_________________________”.  	No, thanks	Yes, I am so glad	Sorry, the seat is taken 	You are welcome	C
//        "(29, 'My uncle _______ golf when he retired from work.     	took on      	took up     	took over     	took after	B
//        "(30, 'By the end of next month, we _______ our English course. 	 have completed 	will be completed	will have completed 	completed	C
//        "(31, 'You should be responsible for_______ you have done. 	that 	why 	which       	what	D
//        "(32, '______________ in the US in 1977, this festival is celebrated with feasts and songs in the home        for seven days and nights. 	Africa introduced 	Africa introducing  	Introducing from Africa 	Introduced from Africa	D
//        "(33, '______________ she spoke did I realized that she was English.	No sooner 	No longer 	Not until 	Hardly	C
//        "(34, 'I'm not opposed to ______ with us, as long as it's only for a few days. 	them to stay  	them staying 	their stay   	their staying	D
//        "(35, 'Henry_______________ a rich man today if he had been more careful in the past.',2, 	'A. will have been', 	'B. will be',  	'C. would have been', 	'D. would be', 	'D'),\n"+
//        "(36, '_________ do women do all the housework with their hands.',2, 	'A.No sooner', 	'B.Not until', 	'C.No more', 	'D.No longer',	'D'),\n"+
//        "(37, 'Please forgive me, I don't ___________ to upset you.     	think      	mind       	mean     	suppose	C
//        "(38, '_______ we have finished the course, we should start doing more revision work .  	For now	Now that	Ever since	By now 	B
//        "(39, '_________ we heard at the conference was encouraging. 	That	Where	When	What	D
//        "(40, 'I'd _________ you didn't leave just at the moment. 	rather	like	better	love	A
//        "(41, 'Forget it. It is no use crying over spilt _________. 	water	juice	milk	lemonade	C
//        "(42, 'Smith knew that he could make a success of the little weekly newspaper in the long _______	time 	run 	distance 	 step	B
//        "(43, '________ that she could not say anything. 	Upset was she  	However upset was she     	So upset was she that  	So upset she was  	C
//        "(44, 'I ________ my best suit at the party last night - everyone else was very casually dresse	needn't wear 	mustn't wear  	needn't have worn 	mustn't have worn	C
//        "(45, 'By far, _________________________ of Saudi Arabia is oil.	it is the most important export                           	the most important export  	the most important export is                               	that it the most important export	B
//        "(46, 'Who did you invite to dinner last night? – No one _______ than Frank and his family.	another 	the other 	other 	the others  	C
//        "(47, 'The man who lives opposite us sometimes comes __________ for a cup of coffee. 	over	off	on	to	A
//        "(48, 'I have three brothers, _____________ are businessmen.	that all of them	who they all	all of whom	who all of them	C
//        "(49, 'It was _________________ that we spent the whole day at the beach.	so nice a weather	such nice weather	such nice a weather 	so a  nice weather	B
//                "(50, '“ What are you going to buy in this store?”   _ “ Nothing, _________ want is too much expensive” 	That I	What I	That what I	What do I	B
//        "(51, 'There's no ______ fixing that toy. He'll just break it again.	point  	worth	harm	good	A
//        "(52, 'It is important that he ____________ with Dr. Baker immediately. 	will speak	speaks	speak	speaks	C
//        "(53, 'I was just walking along the street when I __________ someone I hadn't seen for years.	came across 	came over 	 came by 	came off	A
//        "(54, '“Which of the two boys is granted a scholarship? “            - “_________ of them is .”	All 	None 	Neither 	Both	C
//        "(55, 'I cannot stay up late at night. I prefer ___________ early. 	turning on 	turning up 	turning in   	turning out	C
//        "(56, 'The classroom has not electric fan, ___________ is quite different from that in the advertisement.	what 	who 	which 	that                           	C
//        "(57, 'She is so absent-minde. She _______________ her cell phone three times.	lost 	was losing 	has lost 	had lost	C
//        "(58, 'He always did well at school, despite ___________his early education disrupted by illness.	being 	having 	putting 	sending   	B
        "(59, 'Tom has never been to Madrid, but he talks as if he ______ there himself.', 2,	'A.is', 	'B.was', 	'C.were', 	'D.has been',	'D'),\n"+
        "(60, '___________________about genetic diseases has increased is welcome news.', 2,	'A.Scientific knowledge',  	'B.It was scientific knowledge',	'C.Though scientific knowledge', 'D.That scientific knowledge',	'D'),\n"+
        "(61, 'You looked tire _____________________ hard all day?', 2, 	'A.Were you working', 	'B.Have you been working', 	'C.Do you work', 	'D.Are you working', 'B'),\n"+
//        "(62, '______________ that the company has shown rapid growth in the last two ears.', 2,	'A.It is reported',	'B.They are reported',	'C.The report was',	'D.Reporting', 'A'),\n"+
//        "(63, 'Doing a lot of homework may ___________you to pass the exam.', 2,	'A.make it easier for',	'B.make easier for',	'C.be easy for', 	'D.make easy that',	'A'),\n"+
//        "(64, 'If you need any support, you can _________ me to back you up.', 2,  	'A.believe on', 	'B.rely on',  	'C.depend on',	'D.put on',	'B'),\n"+
//        "(65, 'It is time the government _________measures to reduce the current high unemployment rate.', 2,	'A.takes', 	'B.take', 	'C.took', 	'D.must take',	'C'),\n"+
//        "(66, '_________________ nowadays buys goods on the Internet', 2,	'A.Many people',  	'B.Almost people', 	'C.Most people', 	'D.Many a person',	'D'),\n"+
//        "(67, 'On being told about her sack ____________________.	her boss felt sorry for', 2, 'A. Mary',   	'B.Mary was shocked',   	'C.Mary's face turned pale',   	'D.Mary's reaction was normal',	'B'),\n"+
//        "(68, 'They live on a busy street. _______________ a lot of noise and pollution from traffic', 3,	'A.It must be', 	'B.It must have', 	'C.There must have', 	'D.There must be ',	'D'),\n"+
//            "(69, 'It is essential that Alice __________ Tom of the meeting tomorrow.',3, 'A.remind', 'B.reminds', 'C. will remind', 'D. must remind', 'A'),\n"+
//        "(70, '____________ seemed a miracle to us.',  3,  'A.His recover after so soon',  	'B.That he recovered so soon',  'C.His being recovered so soon',	'D.When he had recovered so soon',  'C'),\n"+
        "(71, 'Remember to ____________ the campfire before you leave.', 3, 'A.put off',	 'B.put down',	'C.put out',	'D.put up', 	'C'),\n"+
        "(72, '_________ you visit him, give him my best wishes.', 3,	'A.Could',	'B.Would',	'C.Should',	'D.Might',	'C'),\n"+
        "(73, '___________ more help, I can call my neighbor.', 3,	'A.Should I need',	'B.I have needed',	'C.I should need',	'D.Needed',	'A'),\n"+
        "(74, 'The house plants need_________ before noon.', 3, 	'A.watering',	'B.to water',	'C.be watered', 	'D.being watered',	'A'),\n"+
        "(75, 'I have never been windsurfing, but I'd love to have________ at it.', 3, 'A.a trial',	'B.a look',	'C.a taste' 	 'D.a go', 	'A'),\n"+
        "(76, '______________you have watched, which film impresses you most ?', 3,	'A.All of films',	'B.All of the films',	'C.Of films all',	'D.Of all the films', 'D'),\n"+
        "(77, 'I am _________tired to think about that problem at the moment.',	3, 'A.nearly',	'B.simply',	'C.much more',	'D.far too',	'D'),\n"+
        "(78, 'The teacher as well as all the students ______ very excited about going camping next week.',	3, 'A.was',  	 'B.were',      	 'C.is',  	'D.has been',	'B'),\n"+
        "(79, '______he does sometimes interests me a lot.',	3, 'A.When',  	'B.Why',  	'C.What',  	'D.How',	'C'), \n"+
        "(80, '______________ of the students in my class could solve the problem yesterday.', 3, 	'A.Not much', 	'B.No', 	'C.None', 	'D.Neither',	'C'),\n"+
        "(81, 'People who work as hard as Bill Gates are few and far ________.', 3,	'A.away', 	'B.between', 	'C.from', 	'D.off',	'B'),\n"+
        "(82, 'John was praised for his bravery, _______ his colleagues were criticized for their cowardice.',	3, 'A.though', 	'B.whereas', 	'C.however', 	'D.therefore',	'B'),\n"+
        "(83, 'We insist that a meeting________ as soon as possible.', 3,	'A.be held', 	'B.is held', 	'C.were held', 	'D.will be held',	'A'),\n"+
        "(84, '_____________ I'm concerned , it's quite all right for you to leave early.',  3,	'A.As long as', 	'B.As far as',  	'C.As well as', 	'D.As much as',	'B'),\n"+
        "(85, 'They are good friends, but in terms of sports, they are worlds ___________.', 3,	'A.away', 	'B.separate', 	'C.apart', 	'D.different',	'C'),\n"+
        "(86, 'Her husband treated her badly. I'm surprised she ___________________ it for so long.',	3, 'A.put up with',	'B.put off',	'C.put through',	'D.put up', 	'A'), \n"+
        "(87, 'Our school doesn't break ______ until the end of July.',	3, 'A.out',	'B.in',	'C.off',	'D.up',	'C'),\n"+
        "(88, 'AIDS is ______________ that scientists are doing research to find a cure.',	3, 'A.a so serious disease',	'B.so a serious diseases',	'C.so serious a disease', 	'D.a such serious disease', 'C'),\n"+
        "(89, '_______________ trying to make him change his min', 3,	'A.It's no point',	'B.It's no hope' 	'C.It's no useless'	'D.It's no use', 'D'),\n"+
        "(90, 'I think you should choose ________ color. This one is too dark.', 3,	'A.other',	'B.another',	'C.the other',	'D.others',	'B'),\n"+
        "(91, 'Were she ten years younger, she ______________ the beauty contest.', 3,	'A.will enter',	'B.had entered',  	'C.would enter',	'D.would have entered',    	'C'),\n"+
        "(92, 'I don't think he will get ________ the shock in such a short period of time.', 3,	'A.off',	'B.out',	'C.over',	'D.away',	'C'),\n"+
        "(93, 'You __________ give me a lift. I can easily catch a bus.', 3,	'A.don't have', 	'B.needn’t', 	'C.don't need', 	'D.mustn't',	'B'),\n"+
        "(94, 'Martin tried on three jackets, ___________ fitted him.', 3,	'A.none', 	'B.none of which', 	'C.none of them', 	'D.not',	'B'),\n"+
        "(95, 'I have English classes ________ day ; on Mondays, Wednesdays and Fridays.', 3,	'A.all other', 	'B.each other', 	'C.every other', 	'D.any other',	'C'),\n"+
        "(96, '_______________ caused certain diseases such as malaria was not known until the early 20th century.', 3,	'A.That mosquitoes', 	'B.Mosquitoes', 	'C.Since mosquitoes', 	'D.Mosquitoes which',	'A'),\n"+
        "(97, 'It's essential that every student __________ the exam before attending the course', 3,	'A.pass', 	'B.passes', 	'C.would pass', 	'D.passed',	'A'),\n"+
        "(98, 'Did your brother go to France ?   - No,  our parents suggested that we_____________ there at night.', 3,	'A.won't go', 	'B.don' t go',  	'C.not go', 	'D.not to go', 	'C'),\n"+
        "(99, '_____________________ appear, they are really much larger than the Earth.', 3,	'A.As the small stars', 	'B.The stars as small', 	'C.Despite of the small stars',   	'D.Small as the stars',   	'D'),\n"+
        "(100, 'I haven't seen Peter for a long time. I will _________ him this weeken', 	3, 'A.call for', 	'B.call in',	'C.call off', 	'D.call on',	'D');");

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
