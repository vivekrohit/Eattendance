package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Student_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);
    }
    public void RegisterStudent_Clicked(View view)
    {
        Intent intent=new Intent(this,RegisterStudent.class);
        startActivity(intent);
    }
    public void On_Clicked(View view)
    {
        Intent intent=new Intent(this,StudentRecord.class);
        startActivity(intent);
    }
}
