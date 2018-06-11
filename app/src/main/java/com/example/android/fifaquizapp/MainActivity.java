package com.example.android.fifaquizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.fifaquizapp";
    int score = 0;
    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order (View view) {
        EditText text = (EditText) findViewById(R.id.name);
        String name = text.getText().toString();
        EditText ansSix = (EditText) findViewById(R.id.quest_6_ans);
        String ans = ansSix.getText().toString();
        if (name.trim().equals("")) {
            Toast.makeText(this, "Please enter your name!!! ", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioGroup questOne = (RadioGroup) findViewById(R.id.quest_1);
        RadioGroup questTwo = (RadioGroup) findViewById(R.id.quest_2);
        RadioGroup questThree = (RadioGroup) findViewById(R.id.quest_3);
        RadioGroup questFour = (RadioGroup) findViewById(R.id.quest_4);
        RadioGroup questFive = (RadioGroup) findViewById(R.id.quest_5);
        RadioGroup questSeven = (RadioGroup) findViewById(R.id.quest_7);
        RadioGroup questEight = (RadioGroup) findViewById(R.id.quest_8);
        RadioGroup questNine = (RadioGroup) findViewById(R.id.quest_9);
        RadioGroup questTen = (RadioGroup) findViewById(R.id.quest_10);
        if ((questOne.getCheckedRadioButtonId() == -1) || (questTwo.getCheckedRadioButtonId() == -1) || (questThree.getCheckedRadioButtonId() == -1)
                || (questFour.getCheckedRadioButtonId() == -1) || (questFive.getCheckedRadioButtonId() == -1)
                || (ans.trim().equals("")) || (questSeven.getCheckedRadioButtonId() == -1)
                || (questEight.getCheckedRadioButtonId() == -1) || (questNine.getCheckedRadioButtonId() == -1)
                || (questTen.getCheckedRadioButtonId() == -1)) {
            Toast.makeText(this, "Please answer all questions!!! ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ans == "Russia") {
            score += 10;
        }
        String order = endMessage(name, score);
        Toast.makeText(this, order, Toast.LENGTH_SHORT).show();
    }

    public String endMessage (String name, int score) {
        String message = "HI, " + name;
        message += "\nYou scored " + score + "%\n";
        switch (score) {
            case 0:
                message += "That's very poor\n You shouldn't be watching soccer.";
                break;
            case 10:
                message += "Something makes me think you've never watched soccer";
                break;
            case 20:
                message += "That's appalling";
                break;
            case 30:
                message += "You need to watch soccer more";
                break;
            case 40:
                message += "Nice try, but you can do better";
                break;
            case 50:
                message += "You're better than most";
                break;
            case 60:
                message += "Nice job. Make sure you don't miss this World cup";
                break;
            case 70:
                message += "Great job. Try again\n You're better than that";
                break;
            case 80:
                message += "You can do better. You're almost there";
                break;
            case 90:
                message += "Genius. But try making it 100";
                break;
            case 100:
                message += "Wow! You really love your soccer";
                break;
        }
        return message;
    }

    public void question1 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_1_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_1_id_b:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_1_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_1_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }

    public void question2 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_2_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_2_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_2_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_2_id_d:
                if (checked) {
                    score += 10;
                }
                break;
        }
    }

    public void question3 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_3_id_a:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_3_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_3_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_3_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }

    public void question4 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_4_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_4_id_b:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_4_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_4_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }

    public void question5 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_5_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_5_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_5_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_5_id_d:
                if (checked) {
                    score += 10;
                }
                break;
        }
    }

    public void question7 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_7_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_7_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_7_id_c:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_7_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_7_id_e:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }

    public void question8 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_8_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_8_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_8_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_8_id_d:
                if (checked) {
                    score += 10;
                }
                break;
        }
    }

    public void question9 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_9_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_9_id_b:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_9_id_c:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_9_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }

    public void question10 (View view) {
        boolean checked = ((RadioButton) view). isChecked();
        switch (view.getId()) {
            case R.id.quest_10_id_a:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_10_id_b:
                if (checked) {
                    score += 10;
                }
                break;

            case R.id.quest_10_id_c:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;

            case R.id.quest_10_id_d:
                if (checked) {
                    //score += 0;
                    return;
                }
                break;
        }
    }
}
