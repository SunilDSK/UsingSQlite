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

    String stu_name,stu_age,stu_cgpa;
    int st_age;
    float st_cgpa;

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
                stu_age = age.getText().toString().trim();
                stu_cgpa = cgpa.getText().toString().trim();
                if(!TextUtils.isEmpty(stu_name) && !TextUtils.isEmpty(stu_age) && !TextUtils.isEmpty(stu_cgpa)){
                    st_age = Integer.parseInt(stu_age);
                    st_cgpa = Float.parseFloat(stu_cgpa);
                    Student student = new Student(stu_name,st_age,st_cgpa);
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
