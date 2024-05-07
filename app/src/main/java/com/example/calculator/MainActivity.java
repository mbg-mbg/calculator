package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean isfirstinput = true; //입력 값이 처음 입력되었는지를 체크
    int resultnumber = 0; //계산된 결과 값을 저장하는 변수
    char operator = '+'; // '' 잊지 말기!

    TextView result_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        result_text = findViewById(R.id.result_text);
    }


    @SuppressLint("ResourceType")
    public void buttonclick(View view) {

        Button getbutton = findViewById(view.getId());

        if (view.getId() == R.id.all_clear_button) {
            isfirstinput = true;
            resultnumber = 0;
            operator = '+';
            result_text.setTextColor(0xff666666);
            result_text.setText(String.valueOf(resultnumber));
        }

        if (view.getId() == R.id.addition_button) {
            int lastnum = Integer.parseInt(result_text.getText().toString());
            if (operator == '+') {
                resultnumber = resultnumber + lastnum;
            } else if (operator == '-') {
                resultnumber = resultnumber - lastnum;
            } else if (operator == '/') {
                resultnumber = resultnumber / lastnum;
            } else if (operator == '*') {
                resultnumber = resultnumber * lastnum;
            }
            operator = '+';
            result_text.setText(String.valueOf(resultnumber));
            isfirstinput = true;


            if (view.getId() == R.id.num_0_button
                    || view.getId() <= R.id.num_1_button
                    || view.getId() <= R.id.num_2_button
                    || view.getId() <= R.id.num_3_button
                    || view.getId() <= R.id.num_4_button
                    || view.getId() <= R.id.num_5_button
                    || view.getId() <= R.id.num_6_button
                    || view.getId() <= R.id.num_7_button
                    || view.getId() <= R.id.num_8_button
                    || view.getId() <= R.id.num_9_button) {

                if (isfirstinput) {
                    result_text.setTextColor(0xff000000);
                    result_text.setText(getbutton.getText().toString());
                    isfirstinput = false;
                } else {
                    result_text.append(getbutton.getText().toString());
                }
            }
        }
    }
}
