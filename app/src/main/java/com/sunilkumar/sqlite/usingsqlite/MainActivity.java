package com.sunilkumar.sqlite.usingsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //UI elements
    EditText name,age,cgpa;
    Button insert,read;

    String stu_name;
    int stu_age;
    float stu_cgpa;

    //Create instance of DatabaseHandler
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References of ui elements
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        cgpa = (EditText) findViewById(R.id.cgpa);
        insert = (Button) findViewById(R.id.insert);
        read = (Button) findViewById(R.id.read);

        dbHandler = new DatabaseHandler(getApplicationContext());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stu_name = name.getText().toString().trim();
                stu_age = Integer.parseInt(age.getText().toString().trim());
                stu_cgpa = Float.parseFloat(cgpa.getText().toString().trim());
                if(!TextUtils.isEmpty(stu_name) || !(stu_age > 0) || !(stu_cgpa > 0)){
                    Student student = new Student(stu_name,stu_age,stu_cgpa);
                    //invoke insert method to insert data
                    dbHandler.addStudent(student);
                }else
                    Toast.makeText(getApplicationContext(),"Please enter values in all the fields",Toast.LENGTH_LONG).show();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //invoke read to see the database content
                dbHandler.readStudent();
            }
        });
    }
}
