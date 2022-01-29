package com.course.example.practicecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button add, subtract, multiply, divide, clear;
    private TextView result;
    private EditText operand;

    private double oper = 0, res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        add = (Button)findViewById(R.id.add);
        subtract = (Button)findViewById(R.id.subtract);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        clear = (Button)findViewById(R.id.clear);
        operand = (EditText)findViewById(R.id.editText);
        result = (TextView)findViewById(R.id.textView);

        //set listener of add button
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                double oper = Double.parseDouble(operand.getText().toString());
                double res = Double.parseDouble(result.getText().toString());
                double sum = res + oper;
                operand.setText("");
                result.setText(new Double(sum).toString());
            }
        });

        //set listener of subtract button
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                double oper = Double.parseDouble(operand.getText().toString());
                double res = Double.parseDouble(result.getText().toString());
                double sum = res - oper;
                operand.setText("");
                result.setText(new Double(sum).toString());
            }
        });

        //set listener of multiply button
        multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                double oper = Double.parseDouble(operand.getText().toString());
                double res = Double.parseDouble(result.getText().toString());
                double sum = res * oper;
                operand.setText("");
                result.setText(new Double(sum).toString());
            }
        });

        //set listener of divide button
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                double oper = Double.parseDouble(operand.getText().toString());
                double res = Double.parseDouble(result.getText().toString());
                double sum = res / oper;
                operand.setText("");
                result.setText(new Double(sum).toString());
            }
        });

        //set listener on clear button
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operand.setText("");
                result.setText("0");
                oper = 0;
                res = 0;
            }
        });

    }




}