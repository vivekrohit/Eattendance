package com.example.yashbohara.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Faculty_Functions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__functions);
    }
    public void TakeAttendance_Clicked(View view)
    {

        Intent i=new Intent(this,TakeAttendance.class);
        startActivity(i);
    }
    public void ViewStudentRecord_Clicked(View view)
    {

    }
    public void UploadAssignment_Clicked(View view)
    {

    }
}
