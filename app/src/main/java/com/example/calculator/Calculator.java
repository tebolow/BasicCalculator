package com.example.calculator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class Calculator extends AppCompatActivity {

    EditText input;
    Button ac;
    ImageView back;
    ImageView percent;
    Button division;
    Button multiplication;
    Button subtraction;
    Button addition;
    Button equal;
    Button dot;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculator), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        input = findViewById(R.id.input);
        ac = findViewById(R.id.ac);
        back = findViewById(R.id.back);
        percent = findViewById(R.id.percent);
        division = findViewById(R.id.division);
        multiplication = findViewById(R.id.multiplication);
        subtraction = findViewById(R.id.subtraction);
        addition = findViewById(R.id.addition);
        equal = findViewById(R.id.equal);
        dot = findViewById(R.id.dot);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        ac.setOnClickListener(v -> display(ac));
        container = findViewById(R.id.container);
        for (int i = 0; i < container.getChildCount(); i++) {
            LinearLayout row = (LinearLayout) container.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                View button = row.getChildAt(j);
                if (button instanceof Button || button instanceof ImageView) {
                    button.setOnClickListener(v -> display(button));
                }
            }
        }
    }

    protected void display(View v){
        String currentInput = input.getText().toString();
        if (v.getId() == R.id.ac){
            input.setText("0");
        } else if (v.getId() == R.id.back) {
            if (currentInput.length() == 1 && !currentInput.equals("0")) {
                input.setText("0");
            } else {
                input.setText(currentInput.substring(0, currentInput.length() - 1));
            }
        } else if (v.getId() == R.id.percent) {
            input.setText(currentInput.substring(0, currentInput.length() - 1));
        } else if (v.getId() == R.id.division) {
            input.setText(currentInput + (char) 247);
        } else if (v.getId() == R.id.equal) {
            calculate(input.getText().toString());
        } else {
            String pressed = ((Button) v).getText().toString();
            if (currentInput.equals("0") && currentInput.length() == 1){
                input.setText(pressed);
            } else {
                input.setText(currentInput + pressed);
            }
        }
    }

    protected void calculate(String input) {
        String[] parts = input.split("(?<=\\D)|(?=\\D)");
        int numberOfOperands = Math.floorDiv(parts.length, 2);
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("\\d+")){
                
            }
        }
        Log.d("Result", Arrays.toString(parts));
    }
}
