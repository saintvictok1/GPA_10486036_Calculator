package com.example.gpa_10486036_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variables that will store the input from android fields
    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;
    private View parentlinearlayout;
    private TextView calculatedgpa;
    private Button computegpabutton;
    private boolean Computed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //associate android ids with java variables
        grade1 = findViewById(R.id.editgrade1);
        grade2 = findViewById(R.id.editgrade2);
        grade3 = findViewById(R.id.editgrade3);
        grade4 = findViewById(R.id.editgrade4);
        grade5 = findViewById(R.id.editgrade5);
        computegpabutton = findViewById(R.id.computegpa_button);
        calculatedgpa = findViewById(R.id.calculatedgpa_textview);
        calculatedgpa.setText("0");
        parentlinearlayout = findViewById(R.id.ParentLinearLayout);
        Computed = false;

        // button where all the magic happens
        computegpabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //runs clear method if condition is met
                if (computegpabutton.getText().equals("Clear")) {
                    clear();
                }
                //displays message if fields are empty
                else if(isFieldsEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Please enter a grade for all fields",
                            Toast.LENGTH_SHORT).show();
                }
                //runs calculation when conditions are met
            else if(!isFieldsEmpty() && !Computed){
                String result = ""+computegpa();
               calculatedgpa.setText(result);
               changeBackground(computegpa());
            }
            }
            });
    }
    //method to do the gpa calculations
    private double computegpa(){
        int a = Integer.parseInt(grade1.getText().toString());
        int b = Integer.parseInt(grade2.getText().toString());
        int c = Integer.parseInt(grade3.getText().toString());
        int d = Integer.parseInt(grade4.getText().toString());
        int e = Integer.parseInt(grade5.getText().toString());

        double sum = a + b + c + d + e;
        double avg = sum /5;
        Computed = true;
        computegpabutton.setText(R.string.clear);
        return avg;
    }
    //method to check if the input fields are empty
    private boolean isFieldsEmpty(){
        return grade1.getText().toString().trim().length() == 0 ||
                grade2.getText().toString().trim().length() == 0 ||
                grade3.getText().toString().trim().length() == 0 ||
                grade4.getText().toString().trim().length() == 0 ||
                grade5.getText().toString().trim().length() == 0;
    }
    //method to reset fields and restore background color
    private void clear(){
        grade1.setText("");
        grade2.setText("");
        grade3.setText("");
        grade4.setText("");
        grade5.setText("");
        Computed = false;
        calculatedgpa.setText("0");
        computegpabutton.setText(R.string.compute);
        parentlinearlayout.setBackgroundColor(getColor(R.color.white));
    }

    //method to change background color based on computed gpa
    private void changeBackground(double finalgrade){
        if (finalgrade <60){
        parentlinearlayout.setBackgroundColor(getColor(R.color.red));

        }else if (finalgrade >=60 && finalgrade <80){
        parentlinearlayout.setBackgroundColor(getColor(R.color.yellow));

        }else if (finalgrade >=80 && finalgrade <=100){
        parentlinearlayout.setBackgroundColor(getColor(R.color.green));
            }
        }

}