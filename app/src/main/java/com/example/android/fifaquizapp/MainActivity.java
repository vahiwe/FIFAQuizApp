package com.example.android.fifaquizapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     * This is the method that controls the submit button action
     * It validates that all questions are answered and that a name is filled
     * Before displaying a toast with name, score and a short message that changes with each score
     * It also checks the correct answer for number 6
     */
    public void order (View view) {
        EditText text =  findViewById(R.id.name);
        String name = text.getText().toString();
        EditText ansSix =  findViewById(R.id.quest_6_ans);
        String ans = ansSix.getText().toString();
        if (name.trim().equals("")) {
            Toast nam = Toast.makeText(this, "Please enter your name!!! ", Toast.LENGTH_SHORT);
            nam.setGravity(Gravity.CENTER, 0, 0);
            nam.show();
            return;
        }
        RadioGroup questOne =  findViewById(R.id.quest_1);
        RadioGroup questTwo =  findViewById(R.id.quest_2);
        RadioGroup questThree =  findViewById(R.id.quest_3);
        RadioGroup questFive =  findViewById(R.id.quest_5);
        RadioGroup questSeven =  findViewById(R.id.quest_7);
        RadioGroup questEight =  findViewById(R.id.quest_8);
        RadioGroup questNine =  findViewById(R.id.quest_9);
        RadioGroup questTen =  findViewById(R.id.quest_10);
        CheckBox box1 =  findViewById(R.id.quest_4_id_a);
        CheckBox box2 =  findViewById(R.id.quest_4_id_b);
        CheckBox box3 =  findViewById(R.id.quest_4_id_c);
        CheckBox box4 =  findViewById(R.id.quest_4_id_d);
        CheckBox box5 =  findViewById(R.id.quest_4_id_e);
        if ((questOne.getCheckedRadioButtonId() == -1) || (questTwo.getCheckedRadioButtonId() == -1) || (questThree.getCheckedRadioButtonId() == -1)
                || (questFive.getCheckedRadioButtonId() == -1)
                || (ans.trim().equals("")) || (questSeven.getCheckedRadioButtonId() == -1)
                || (questEight.getCheckedRadioButtonId() == -1) || (questNine.getCheckedRadioButtonId() == -1)
                || (questTen.getCheckedRadioButtonId() == -1) || ((!box1.isChecked()) && (!box2.isChecked()) && (!box3.isChecked())
                && (!box4.isChecked()) && (!box5.isChecked()))) {
            Toast chek = Toast.makeText(this, "Please answer all questions!!! ", Toast.LENGTH_SHORT);
            chek.setGravity(Gravity.CENTER, 0, 0);
            chek.show();
            return;
        }
        if (ans.trim().equalsIgnoreCase("russia")) {
            score += 10;
        }
        if (score > 100) {
            score = 100;
        }
        String messag = "Check the questions answered wrongly while app resets";
        wrongAnswer();
        String order = endMessage(name, score);
        Toast res = Toast.makeText(this, order, Toast.LENGTH_LONG);
        res.setGravity(Gravity.CENTER, 0, 0);
        res.show();
        Toast inf = Toast.makeText(this, messag, Toast.LENGTH_LONG);
        inf.setGravity(Gravity.CENTER, 0, 0);
        inf.show();
        Toast inf2 = Toast.makeText(this, "Resetting..............", Toast.LENGTH_LONG);
        inf2.setGravity(Gravity.CENTER, 0, 0);
        inf2.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reset();
            }
        }, 13000);
    }


    /**
     *
     * @param name {int}
     * @param score {String}
     * @return
     * This method returns the final message for the toast using score and name
     * It also generates different replies based on your score using switch statements
     */
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

    /**
     * This method resets the app after all the questions have been submitted
     */
    public void reset () {
        EditText text  =  findViewById(R.id.quest_6_ans);
        text.setText(null);
        EditText txt =  findViewById(R.id.name);
        txt.setText(null);
        RadioGroup questOne =  findViewById(R.id.quest_1);
        RadioGroup questTwo =  findViewById(R.id.quest_2);
        RadioGroup questThree =  findViewById(R.id.quest_3);
        RadioGroup questFive =  findViewById(R.id.quest_5);
        RadioGroup questSeven =  findViewById(R.id.quest_7);
        RadioGroup questEight =  findViewById(R.id.quest_8);
        RadioGroup questNine =  findViewById(R.id.quest_9);
        RadioGroup questTen =  findViewById(R.id.quest_10);
        questOne.clearCheck();
        questTwo.clearCheck();
        questThree.clearCheck();
        questFive.clearCheck();
        questSeven.clearCheck();
        questEight.clearCheck();
        questNine.clearCheck();
        questTen.clearCheck();
        CheckBox box1 =  findViewById(R.id.quest_4_id_a);
        CheckBox box2 =  findViewById(R.id.quest_4_id_b);
        CheckBox box3 =  findViewById(R.id.quest_4_id_c);
        CheckBox box4 =  findViewById(R.id.quest_4_id_d);
        CheckBox box5 =  findViewById(R.id.quest_4_id_e);
        box1.setChecked(false);
        box2.setChecked(false);
        box3.setChecked(false);
        box4.setChecked(false);
        box5.setChecked(false);
        ImageView wrong_1 = findViewById(R.id.wrong_1);
        ImageView wrong_2 = findViewById(R.id.wrong_2);
        ImageView wrong_3 = findViewById(R.id.wrong_3);
        ImageView wrong_4 = findViewById(R.id.wrong_4);
        ImageView wrong_5 = findViewById(R.id.wrong_5);
        ImageView wrong_6 = findViewById(R.id.wrong_6);
        ImageView wrong_7 = findViewById(R.id.wrong_7);
        ImageView wrong_8 = findViewById(R.id.wrong_8);
        ImageView wrong_9 = findViewById(R.id.wrong_9);
        ImageView wrong_10 = findViewById(R.id.wrong_10);
        wrong_1.setVisibility(View.INVISIBLE);
        wrong_2.setVisibility(View.INVISIBLE);
        wrong_3.setVisibility(View.INVISIBLE);
        wrong_4.setVisibility(View.INVISIBLE);
        wrong_5.setVisibility(View.INVISIBLE);
        wrong_6.setVisibility(View.INVISIBLE);
        wrong_7.setVisibility(View.INVISIBLE);
        wrong_8.setVisibility(View.INVISIBLE);
        wrong_9.setVisibility(View.INVISIBLE);
        wrong_10.setVisibility(View.INVISIBLE);
        score = 0;
    }

    /**
     * This method indicates to the user questions that were answered wrongly
     */
    public void wrongAnswer () {
        RadioButton quest1a = findViewById(R.id.quest_1_id_a);
        RadioButton quest1c = findViewById(R.id.quest_1_id_c);
        RadioButton quest1d = findViewById(R.id.quest_1_id_d);
        RadioButton quest2a = findViewById(R.id.quest_2_id_a);
        RadioButton quest2b = findViewById(R.id.quest_2_id_b);
        RadioButton quest2c = findViewById(R.id.quest_2_id_c);
        RadioButton quest3b = findViewById(R.id.quest_3_id_b);
        RadioButton quest3c = findViewById(R.id.quest_3_id_c);
        RadioButton quest3d = findViewById(R.id.quest_3_id_d);
        CheckBox box1 =  findViewById(R.id.quest_4_id_a);
        CheckBox box2 =  findViewById(R.id.quest_4_id_b);
        CheckBox box3 =  findViewById(R.id.quest_4_id_c);
        CheckBox box4 =  findViewById(R.id.quest_4_id_d);
        CheckBox box5 =  findViewById(R.id.quest_4_id_e);
        RadioButton quest5a = findViewById(R.id.quest_5_id_a);
        RadioButton quest5b = findViewById(R.id.quest_5_id_b);
        RadioButton quest5c = findViewById(R.id.quest_5_id_c);
        EditText quest6 = findViewById(R.id.quest_6_ans);
        RadioButton quest7a = findViewById(R.id.quest_7_id_a);
        RadioButton quest7b = findViewById(R.id.quest_7_id_b);
        RadioButton quest7d = findViewById(R.id.quest_7_id_d);
        RadioButton quest7e = findViewById(R.id.quest_7_id_e);
        RadioButton quest8a = findViewById(R.id.quest_8_id_a);
        RadioButton quest8b = findViewById(R.id.quest_8_id_b);
        RadioButton quest8c = findViewById(R.id.quest_8_id_c);
        RadioButton quest9a = findViewById(R.id.quest_9_id_a);
        RadioButton quest9b = findViewById(R.id.quest_9_id_b);
        RadioButton quest9d = findViewById(R.id.quest_9_id_d);
        RadioButton quest10a = findViewById(R.id.quest_10_id_a);
        RadioButton quest10c = findViewById(R.id.quest_10_id_c);
        RadioButton quest10d = findViewById(R.id.quest_10_id_d);
        if (quest1a.isChecked() || quest1c.isChecked() || quest1d.isChecked()) {
            ImageView wrong_1 = findViewById(R.id.wrong_1);
            wrong_1.setVisibility(View.VISIBLE);
        }
        if (quest2a.isChecked() || quest2b.isChecked() || quest2c.isChecked()) {
            ImageView wrong_2 = findViewById(R.id.wrong_2);
            wrong_2.setVisibility(View.VISIBLE);
        }
        if (quest3b.isChecked() || quest3c.isChecked() || quest3d.isChecked()) {
            ImageView wrong_3 = findViewById(R.id.wrong_3);
            wrong_3.setVisibility(View.VISIBLE);
        }
        if (!(box3.isChecked() && box5.isChecked() && !(box1.isChecked()) && !(box2.isChecked()) && !(box4.isChecked()))) {
            ImageView wrong_4 = findViewById(R.id.wrong_4);
            wrong_4.setVisibility(View.VISIBLE);
        }
        if (quest5b.isChecked() || quest5c.isChecked() || quest5a.isChecked()) {
            ImageView wrong_5 = findViewById(R.id.wrong_5);
            wrong_5.setVisibility(View.VISIBLE);
        }
        if (!( quest6.getText().toString().trim().equalsIgnoreCase("russia"))) {
            ImageView wrong_6 = findViewById(R.id.wrong_6);
            wrong_6.setVisibility(View.VISIBLE);
        }
        if (quest7b.isChecked() || quest7a.isChecked() || quest7d.isChecked() || quest7e.isChecked()) {
            ImageView wrong_7 = findViewById(R.id.wrong_7);
            wrong_7.setVisibility(View.VISIBLE);
        }
        if (quest8b.isChecked() || quest8c.isChecked() || quest8a.isChecked()) {
            ImageView wrong_8 = findViewById(R.id.wrong_8);
            wrong_8.setVisibility(View.VISIBLE);
        }
        if (quest9b.isChecked() || quest9a.isChecked() || quest9d.isChecked()) {
            ImageView wrong_9 = findViewById(R.id.wrong_9);
            wrong_9.setVisibility(View.VISIBLE);
        }
        if (quest10d.isChecked() || quest10c.isChecked() || quest10a.isChecked()) {
            ImageView wrong_10 = findViewById(R.id.wrong_10);
            wrong_10.setVisibility(View.VISIBLE);
        }
    }

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question one using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question two using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question three using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question four
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
    public void question4 (View view) {
        CheckBox box1 =  findViewById(R.id.quest_4_id_a);
        CheckBox box2 =  findViewById(R.id.quest_4_id_b);
        CheckBox box3 =  findViewById(R.id.quest_4_id_c);
        CheckBox box4 =  findViewById(R.id.quest_4_id_d);
        CheckBox box5 =  findViewById(R.id.quest_4_id_e);
        boolean val1 = box1.isChecked();
        boolean val2 = box2.isChecked();
        boolean val3 = box3.isChecked();
        boolean val4 = box4.isChecked();
        boolean val5 = box5.isChecked();

        if (val3 && val5 && !val1 && !val2 && !val4) {
            score += 10;
        }

    }

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question five using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question seven using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question eight using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question nine using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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

    /**
     *
     * @param view
     * This method checks if the correct answer is chosen for question ten using switch statements
     * It also adds to the score if the correct answer is chosen and does nothing otherwise
     */
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
