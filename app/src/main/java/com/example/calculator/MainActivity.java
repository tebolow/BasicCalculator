package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    TextView result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.sum_button);
        btn.setOnClickListener(view -> getSum());
    }
    private void getSum(){
        if (!input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty()){
            double number1 = Double.parseDouble(input1.getText().toString());
            double number2 = Double.parseDouble(input2.getText().toString());
            result.setText("Result = " + (number1 + number2));
        }
        else {
            result.setText("Please enter valid values");
        }
    }
}